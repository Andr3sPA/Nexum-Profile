package co.edu.udea.nexum.profile.common.infrastructure.configuration.security.filter;

import co.edu.udea.nexum.profile.auth.domain.api.TokenServicePort;
import co.edu.udea.nexum.profile.auth.domain.model.AuthenticatedUser;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.utils.context.TokenContext;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static co.edu.udea.nexum.profile.common.infrastructure.utils.constants.ConfigurationConstants.AUTHORIZATION_HEADER;
import static co.edu.udea.nexum.profile.common.infrastructure.utils.constants.ConfigurationConstants.TOKEN_PREFIX;

@Component
@RequiredArgsConstructor
@Generated
public class JwtAuthorizationFilter extends OncePerRequestFilter {
    private final TokenServicePort tokenServicePort;
    private final UserDetailsService userDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader(AUTHORIZATION_HEADER);

        if (authorizationHeader == null || !authorizationHeader.startsWith(TOKEN_PREFIX)) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = authorizationHeader.substring(TOKEN_PREFIX.length());
        AuthenticatedUser authenticatedUser = tokenServicePort.validateToken(token);

        TokenContext.setToken(authenticatedUser.getToken());
        setContextAuthentication(request, authenticatedUser);

        filterChain.doFilter(request, response);
        TokenContext.clear();
    }

    private void setContextAuthentication(HttpServletRequest request, AuthenticatedUser authenticatedUser) {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(authenticatedUser.getId().toString());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails.getUsername(),
                    userDetails.getPassword(),
                    userDetails.getAuthorities()
            );
            authentication.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }
}
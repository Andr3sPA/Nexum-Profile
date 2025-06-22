package co.edu.udea.nexum.profile.auth.infrastructure.output.security.adapter;

import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.domain.model.AuthenticatedUser;
import co.edu.udea.nexum.profile.auth.domain.model.AuthorizationData;
import co.edu.udea.nexum.profile.auth.domain.spi.security.AuthenticationSecurityPort;
import co.edu.udea.nexum.profile.auth.infrastructure.output.security.service.JwtService;
import co.edu.udea.nexum.profile.common.infrastructure.utils.context.TokenContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.Map;

import static co.edu.udea.nexum.profile.auth.infrastructure.output.security.utils.SecurityConstants.CLAIMS_ROLE_KEY;
import static co.edu.udea.nexum.profile.auth.infrastructure.output.security.utils.SecurityFunctions.buildAuthenticatedUser;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthenticationSecurityAdapter implements AuthenticationSecurityPort {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public AuthenticatedUser authenticate(Auth auth, AuthorizationData authorizationData) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authorizationData.getId().toString(),
                        authorizationData.getPassword()
                )
        );
        final Map<String, String> claims = Map.of(
                CLAIMS_ROLE_KEY,
                auth.getRole().getName().name()
        );
        String token = jwtService.generateToken(claims, authorizationData.getId().toString());
        return AuthenticatedUser.builder()
                .id(authorizationData.getId())
                .role(auth.getRole().getName())
                .token(token)
                .build();
    }

    @Override
    public AuthenticatedUser getAuthenticatedUser() {
        return buildAuthenticatedUser(
                TokenContext.getToken(),
                jwtService
        );
    }

}

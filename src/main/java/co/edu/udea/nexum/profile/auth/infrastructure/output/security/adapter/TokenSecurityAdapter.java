package co.edu.udea.nexum.profile.auth.infrastructure.output.security.adapter;

import co.edu.udea.nexum.profile.auth.domain.model.AuthenticatedUser;
import co.edu.udea.nexum.profile.auth.domain.spi.security.TokenSecurityPort;
import co.edu.udea.nexum.profile.auth.infrastructure.output.security.service.JwtService;
import co.edu.udea.nexum.profile.common.domain.exception.ExpiredTokenException;
import co.edu.udea.nexum.profile.common.domain.exception.InvalidTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static co.edu.udea.nexum.profile.auth.infrastructure.output.security.utils.SecurityFunctions.buildAuthenticatedUser;

@Component
@RequiredArgsConstructor
public class TokenSecurityAdapter implements TokenSecurityPort {
    private final JwtService jwtService;

    @Override
    public AuthenticatedUser validateToken(String token) throws InvalidTokenException, ExpiredTokenException {
        return buildAuthenticatedUser(token, jwtService);
    }
}

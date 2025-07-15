package co.edu.udea.nexum.profile.auth.infrastructure.output.security.utils.functions;

import co.edu.udea.nexum.profile.auth.domain.model.AuthenticatedUser;
import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.auth.infrastructure.output.security.service.JwtService;
import co.edu.udea.nexum.profile.common.domain.exception.InvalidTokenException;

import java.util.UUID;

import static co.edu.udea.nexum.profile.auth.infrastructure.output.security.utils.constants.SecurityConstants.CLAIMS_ROLE_KEY;

public class SecurityFunctions {

    public static AuthenticatedUser buildAuthenticatedUser(String token, JwtService jwtService) {
        String id = jwtService.extractUsername(token);
        RoleName role = RoleName.valueOf(jwtService.getClaimFromKey(token, CLAIMS_ROLE_KEY, String.class));
        if(!jwtService.isTokenValid(token, id)) throw new InvalidTokenException();
        return AuthenticatedUser.builder()
                .id(UUID.fromString(id))
                .role(role)
                .token(token)
                .build();
    }
}

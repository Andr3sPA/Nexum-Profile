package co.edu.udea.nexum.profile.auth.domain.usecase;

import co.edu.udea.nexum.profile.auth.domain.api.TokenServicePort;
import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.domain.model.AuthenticatedUser;
import co.edu.udea.nexum.profile.auth.domain.spi.persistence.AuthPersistencePort;
import co.edu.udea.nexum.profile.auth.domain.spi.security.TokenSecurityPort;
import co.edu.udea.nexum.profile.user.domain.model.User;

public class TokenUseCase implements TokenServicePort {
    private final TokenSecurityPort tokenSecurityPort;
    private final AuthPersistencePort authPersistencePort;

    public TokenUseCase(
            TokenSecurityPort tokenSecurityPort,
            AuthPersistencePort authPersistencePort
    ) {
        this.tokenSecurityPort = tokenSecurityPort;
        this.authPersistencePort = authPersistencePort;
    }

    @Override
    public AuthenticatedUser validateToken(String token) {
        return tokenSecurityPort.validateToken(token);
    }

    @Override
    public User getUserByToken(String token) {
        AuthenticatedUser authenticatedUser = validateToken(token);
        Auth auth = authPersistencePort.findById(authenticatedUser.getId());
        return auth.getUser();
    }
}

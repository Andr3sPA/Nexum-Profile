package co.edu.udea.nexum.profile.security.domain.utils.helpers;

import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.domain.model.AuthenticatedUser;
import co.edu.udea.nexum.profile.auth.domain.spi.security.AuthenticationSecurityPort;
import co.edu.udea.nexum.profile.common.domain.exception.ForbiddenResourceAccessException;

import java.util.UUID;

import static co.edu.udea.nexum.profile.security.domain.utils.constants.SecurityConstants.ALLOWED_ROLES;
import static co.edu.udea.nexum.profile.security.domain.utils.constants.SecurityConstants.*;

import co.edu.udea.nexum.profile.auth.domain.spi.persistence.AuthPersistencePort;

public class SecurityHelper {
    private SecurityHelper() {
        throw new IllegalStateException(UTILITY_CLASS);
    }

    private static AuthenticationSecurityPort authenticationSecurityPort;
    private static AuthPersistencePort authPersistencePort;

    public static SecurityHelperConfigurator configure() {
        return new SecurityHelperConfigurator();
    }

    public static void validateCommonUserPermission(UUID userId) {
        AuthenticatedUser authenticatedUser = authenticationSecurityPort.getAuthenticatedUser();
        Auth auth = authPersistencePort.findById(authenticatedUser.getId());

        if (!ALLOWED_ROLES.contains(authenticatedUser.getRole()) &&
                !auth.getUser().getId().equals(userId)) {
            throw new ForbiddenResourceAccessException();
        }
    }

    public static class SecurityHelperConfigurator {

        public SecurityHelperConfigurator authenticationSecurityHelper(AuthenticationSecurityPort securityPort) {
            authenticationSecurityPort = securityPort;
            return this;
        }

        public SecurityHelperConfigurator authPersistencePort(AuthPersistencePort persistencePort) {
            authPersistencePort = persistencePort;
            return this;
        }

        public SecurityHelperConfigurator done() {
            if (authenticationSecurityPort == null || authPersistencePort == null)
                throw new IllegalStateException(HELPER_NOT_PROPERLY_CONFIGURED);
            return this;
        }
    }
}

package co.edu.udea.nexum.profile.auth.domain.spi.security;

import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.domain.model.AuthenticatedUser;
import co.edu.udea.nexum.profile.auth.domain.model.AuthorizationData;

public interface AuthenticationSecurityPort {
    AuthenticatedUser authenticate(Auth auth, AuthorizationData authorizationData);
    AuthenticatedUser getAuthenticatedUser();
}

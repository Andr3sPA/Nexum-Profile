package co.edu.udea.nexum.profile.auth.domain.api;

import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.domain.model.AuthenticatedUser;
import co.edu.udea.nexum.profile.user.domain.model.User;

public interface AuthServicePort {
    User registerAdministrative(Auth auth, User user);
    User registerGraduate(Auth auth, User user);
    AuthenticatedUser login(String email, String password);
    AuthenticatedUser getAuthenticatedUser();
}

package co.edu.udea.nexum.profile.auth.domain.api;

import java.util.UUID;

import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.domain.model.AuthenticatedUser;
import co.edu.udea.nexum.profile.user.domain.model.User;

public interface AuthServicePort {
    User registerAdministrative(Auth auth, User user);
    User registerGraduate(Auth auth, User user);
    User registerEmployer(Auth auth, User user);
    AuthenticatedUser login(String email, String password);
    AuthenticatedUser getAuthenticatedUser();
    Auth getByUserId(UUID userId);
    void verifyAccount(String token);
    void requestPasswordReset(String email);
    void resetPassword(String token, String newPassword);
}

package co.edu.udea.nexum.profile.auth.application.handler;

import java.util.UUID;

import co.edu.udea.nexum.profile.auth.application.dto.request.AuthenticationRequest;
import co.edu.udea.nexum.profile.auth.application.dto.request.EmployerRegisterRequest;
import co.edu.udea.nexum.profile.auth.application.dto.request.UserRegisterRequest;
import co.edu.udea.nexum.profile.auth.application.dto.response.AuthResponse;
import co.edu.udea.nexum.profile.auth.application.dto.response.AuthenticatedUserResponse;
import co.edu.udea.nexum.profile.auth.application.dto.response.UserRegisteredResponse;

public interface AuthHandler {
    UserRegisteredResponse registerAdministrative(UserRegisterRequest request);
    UserRegisteredResponse registerGraduate(UserRegisterRequest request);
    UserRegisteredResponse registerEmployer(EmployerRegisterRequest request);
    AuthenticatedUserResponse login(AuthenticationRequest request);
    AuthenticatedUserResponse getAuthenticatedUser();
    AuthResponse getByUserId(UUID userId);
    void verifyAccount(String email, String token);
    void requestPasswordReset(String email);
    void resetPassword(String token, String newPassword);
    void resendVerification(String email);
}

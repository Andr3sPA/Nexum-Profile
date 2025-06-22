package co.edu.udea.nexum.profile.auth.application.handler;

import co.edu.udea.nexum.profile.auth.application.dto.request.AuthenticationRequest;
import co.edu.udea.nexum.profile.auth.application.dto.request.UserRegisterRequest;
import co.edu.udea.nexum.profile.auth.application.dto.response.AuthenticatedUserResponse;
import co.edu.udea.nexum.profile.auth.application.dto.response.UserRegisteredResponse;

public interface AuthHandler {
    UserRegisteredResponse registerAdministrative(UserRegisterRequest request);
    UserRegisteredResponse registerGraduate(UserRegisterRequest request);
    AuthenticatedUserResponse login(AuthenticationRequest request);
    AuthenticatedUserResponse getAuthenticatedUser();
}

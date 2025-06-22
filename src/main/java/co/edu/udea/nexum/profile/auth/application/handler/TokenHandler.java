package co.edu.udea.nexum.profile.auth.application.handler;

import co.edu.udea.nexum.profile.auth.application.dto.response.AuthenticatedUserResponse;
import co.edu.udea.nexum.profile.user.application.dto.response.UserResponse;

public interface TokenHandler {
    AuthenticatedUserResponse validateToken(String token);
    UserResponse getUserByToken(String token);
}

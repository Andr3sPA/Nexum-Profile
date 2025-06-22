package co.edu.udea.nexum.profile.user.application.handler;

import co.edu.udea.nexum.profile.common.application.handler.BaseCrudHandler;
import co.edu.udea.nexum.profile.user.application.dto.request.UserRequest;
import co.edu.udea.nexum.profile.user.application.dto.response.UserResponse;

import java.util.UUID;

public interface UserHandler extends BaseCrudHandler<UUID, UserResponse, UserRequest> {
}

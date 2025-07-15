package co.edu.udea.nexum.profile.user.application.handler.impl;

import co.edu.udea.nexum.profile.common.application.handler.impl.BaseCrudHandlerImpl;
import co.edu.udea.nexum.profile.common.application.mapper.BaseRequestMapper;
import co.edu.udea.nexum.profile.common.application.mapper.BaseResponseMapper;
import co.edu.udea.nexum.profile.common.domain.api.BaseCrudServicePort;
import co.edu.udea.nexum.profile.user.application.dto.request.UserRequest;
import co.edu.udea.nexum.profile.user.application.dto.response.UserResponse;
import co.edu.udea.nexum.profile.user.application.handler.UserHandler;
import co.edu.udea.nexum.profile.user.application.mapper.request.UserRequestMapper;
import co.edu.udea.nexum.profile.user.application.mapper.response.UserResponseMapper;
import co.edu.udea.nexum.profile.user.domain.api.UserServicePort;
import co.edu.udea.nexum.profile.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserHandlerImpl extends BaseCrudHandlerImpl<UUID, User, UserResponse, UserRequest> implements UserHandler {
    private final UserServicePort userServicePort;
    private final UserResponseMapper userResponseMapper;
    private final UserRequestMapper userRequestMapper;

    @Override
    protected BaseCrudServicePort<UUID, User> getServicePort() {
        return userServicePort;
    }

    @Override
    protected BaseResponseMapper<User, UserResponse> getResponseMapper() {
        return userResponseMapper;
    }

    @Override
    protected BaseRequestMapper<User, UserRequest> getRequestMapper() {
        return userRequestMapper;
    }

    @Override
    public UserResponse findAuthenticatedUser() {
        return userResponseMapper.toResponse(
                userServicePort.findAuthenticatedUser()
        );
    }
}

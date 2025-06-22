package co.edu.udea.nexum.profile.auth.application.handler.impl;

import co.edu.udea.nexum.profile.auth.application.dto.response.AuthenticatedUserResponse;
import co.edu.udea.nexum.profile.auth.application.handler.TokenHandler;
import co.edu.udea.nexum.profile.auth.application.mapper.response.AuthenticatedUserResponseMapper;
import co.edu.udea.nexum.profile.auth.domain.api.TokenServicePort;
import co.edu.udea.nexum.profile.user.application.dto.response.UserResponse;
import co.edu.udea.nexum.profile.user.application.mapper.response.UserResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenHandlerImpl implements TokenHandler {
    private final TokenServicePort tokenServicePort;
    private final AuthenticatedUserResponseMapper authenticatedUserResponseMapper;
    private final UserResponseMapper userResponseMapper;

    @Override
    public AuthenticatedUserResponse validateToken(String token) {
        return authenticatedUserResponseMapper.toResponse(
                tokenServicePort.validateToken(token)
        );
    }

    @Override
    public UserResponse getUserByToken(String token) {
        return userResponseMapper.toResponse(
                tokenServicePort.getUserByToken(token)
        );
    }
}

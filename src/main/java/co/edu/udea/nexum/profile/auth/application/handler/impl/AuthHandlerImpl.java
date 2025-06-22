package co.edu.udea.nexum.profile.auth.application.handler.impl;

import co.edu.udea.nexum.profile.auth.application.dto.request.AuthenticationRequest;
import co.edu.udea.nexum.profile.auth.application.dto.request.UserRegisterRequest;
import co.edu.udea.nexum.profile.auth.application.dto.response.AuthenticatedUserResponse;
import co.edu.udea.nexum.profile.auth.application.dto.response.UserRegisteredResponse;
import co.edu.udea.nexum.profile.auth.application.handler.AuthHandler;
import co.edu.udea.nexum.profile.auth.application.mapper.request.AuthRequestMapper;
import co.edu.udea.nexum.profile.auth.application.mapper.response.AuthenticatedUserResponseMapper;
import co.edu.udea.nexum.profile.auth.application.mapper.response.UserRegisteredResponseMapper;
import co.edu.udea.nexum.profile.auth.domain.api.AuthServicePort;
import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthHandlerImpl implements AuthHandler {
    private final AuthServicePort authServicePort;
    private final AuthRequestMapper authRequestMapper;
    private final AuthenticatedUserResponseMapper authenticatedUserResponseMapper;
    private final UserRegisteredResponseMapper userRegisteredResponseMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserRegisteredResponse registerAdministrative(UserRegisterRequest request) {
        User user = authRequestMapper.toDomainUser(request);
        Auth auth = authRequestMapper.toDomainAuth(request);
        auth.setPassword(passwordEncoder.encode(auth.getPassword()));
        return userRegisteredResponseMapper.toResponse(
                authServicePort.registerAdministrative(auth, user)
        );
    }

    @Override
    public UserRegisteredResponse registerGraduate(UserRegisterRequest request) {
        User user = authRequestMapper.toDomainUser(request);
        Auth auth = authRequestMapper.toDomainAuth(request);
        auth.setPassword(passwordEncoder.encode(auth.getPassword()));
        return userRegisteredResponseMapper.toResponse(
                authServicePort.registerGraduate(auth, user)
        );
    }

    @Override
    public AuthenticatedUserResponse login(AuthenticationRequest request) {
        return authenticatedUserResponseMapper.toResponse(
                authServicePort.login(request.getEmail(), request.getPassword())
        );
    }

    @Override
    public AuthenticatedUserResponse getAuthenticatedUser() {
        return authenticatedUserResponseMapper.toResponse(
                authServicePort.getAuthenticatedUser()
        );
    }
}

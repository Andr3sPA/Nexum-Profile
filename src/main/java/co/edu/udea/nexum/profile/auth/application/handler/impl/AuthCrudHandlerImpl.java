package co.edu.udea.nexum.profile.auth.application.handler.impl;

import co.edu.udea.nexum.profile.auth.application.dto.request.AuthRequest;
import co.edu.udea.nexum.profile.auth.application.dto.request.filter.AuthFilterRequest;
import co.edu.udea.nexum.profile.auth.application.dto.response.AuthResponse;
import co.edu.udea.nexum.profile.auth.application.handler.AuthCrudHandler;
import co.edu.udea.nexum.profile.auth.application.mapper.request.AuthRequestMapper;
import co.edu.udea.nexum.profile.auth.application.mapper.response.AuthResponseMapper;
import co.edu.udea.nexum.profile.auth.domain.api.AuthCrudServicePort;
import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.domain.model.filter.AuthFilter;
import co.edu.udea.nexum.profile.common.application.dto.request.PaginationRequest;
import co.edu.udea.nexum.profile.common.application.dto.response.PageResponse;
import co.edu.udea.nexum.profile.common.application.handler.impl.BaseCrudHandlerImpl;
import co.edu.udea.nexum.profile.common.application.mapper.BaseRequestMapper;
import co.edu.udea.nexum.profile.common.application.mapper.BaseResponseMapper;
import co.edu.udea.nexum.profile.common.domain.api.BaseCrudServicePort;
import co.edu.udea.nexum.profile.common.domain.utils.pagination.PaginationData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthCrudHandlerImpl extends BaseCrudHandlerImpl<UUID, Auth, AuthResponse, AuthRequest> implements AuthCrudHandler {
    private final AuthCrudServicePort authCrudServicePort;
    private final AuthResponseMapper authResponseMapper;
    private final AuthRequestMapper authRequestMapper;

    @Override
    public PageResponse<AuthResponse> findAll(AuthFilterRequest authFilterRequest, PaginationRequest pagination) {
        PaginationData data = pagination.toDomain();
        AuthFilter filter = authRequestMapper.toDomain(authFilterRequest);
        return authResponseMapper.toResponses(
                authCrudServicePort.findAll(filter, data)
        );
    }

    @Override
    protected BaseCrudServicePort<UUID, Auth> getServicePort() {
        return authCrudServicePort;
    }

    @Override
    protected BaseResponseMapper<Auth, AuthResponse> getResponseMapper() {
        return authResponseMapper;
    }

    @Override
    protected BaseRequestMapper<Auth, AuthRequest> getRequestMapper() {
        return authRequestMapper;
    }
}

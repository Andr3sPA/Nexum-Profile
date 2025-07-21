package co.edu.udea.nexum.profile.auth.application.handler;

import co.edu.udea.nexum.profile.auth.application.dto.request.AuthRequest;
import co.edu.udea.nexum.profile.auth.application.dto.request.filter.AuthFilterRequest;
import co.edu.udea.nexum.profile.auth.application.dto.response.AuthResponse;
import co.edu.udea.nexum.profile.common.application.dto.request.PaginationRequest;
import co.edu.udea.nexum.profile.common.application.dto.response.PageResponse;
import co.edu.udea.nexum.profile.common.application.handler.BaseCrudHandler;

import java.util.UUID;

public interface AuthCrudHandler extends BaseCrudHandler<UUID, AuthResponse, AuthRequest> {
    PageResponse<AuthResponse> findAll(AuthFilterRequest filter, PaginationRequest pagination);
}

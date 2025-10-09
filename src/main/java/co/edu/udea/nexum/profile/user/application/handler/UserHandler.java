package co.edu.udea.nexum.profile.user.application.handler;

import co.edu.udea.nexum.profile.common.application.dto.request.PaginationRequest;
import co.edu.udea.nexum.profile.common.application.dto.response.PageResponse;
import co.edu.udea.nexum.profile.common.application.handler.BaseCrudHandler;
import co.edu.udea.nexum.profile.user.application.dto.request.UserRequest;
import co.edu.udea.nexum.profile.user.application.dto.request.filter.UserFilterRequest;
import co.edu.udea.nexum.profile.user.application.dto.response.UserResponse;
import co.edu.udea.nexum.profile.user.application.dto.response.basic.BasicUserResponse;

import java.util.UUID;

public interface UserHandler extends BaseCrudHandler<UUID, UserResponse, UserRequest> {
    UserResponse findAuthenticatedUser();
    BasicUserResponse findAuthenticatedUserBasic();
    BasicUserResponse findUserBasicByAuthId(UUID authId);
    PageResponse<BasicUserResponse> findAllFiltered(UserFilterRequest userFilterRequest, PaginationRequest paginationRequest);
}

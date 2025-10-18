package co.edu.udea.nexum.profile.auth.application.mapper.response;

import co.edu.udea.nexum.profile.auth.application.dto.response.AuthResponse;
import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.common.application.dto.response.PageResponse;
import co.edu.udea.nexum.profile.common.application.mapper.BaseResponseMapper;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.pagination.DomainPage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthResponseMapper extends BaseResponseMapper<Auth, AuthResponse> {
    @Override
    @Mapping(target = "role", source = "role.name")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "middleName", source = "user.middleName")
    @Mapping(target = "lastname", source = "user.lastname")
    @Mapping(target = "secondLastname", source = "user.secondLastname")
    AuthResponse toResponse(Auth auth);

    PageResponse<AuthResponse> toResponses(DomainPage<Auth> auth);
}

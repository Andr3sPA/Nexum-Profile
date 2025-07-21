package co.edu.udea.nexum.profile.auth.application.mapper.request;

import co.edu.udea.nexum.profile.auth.application.dto.request.AuthRequest;
import co.edu.udea.nexum.profile.auth.application.dto.request.UserRegisterRequest;
import co.edu.udea.nexum.profile.auth.application.dto.request.filter.AuthFilterRequest;
import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.domain.model.Role;
import co.edu.udea.nexum.profile.auth.domain.model.filter.AuthFilter;
import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.common.application.mapper.BaseRequestMapper;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.user.domain.model.IdentityDocumentType;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.utils.enums.Gender;
import co.edu.udea.nexum.profile.user.domain.utils.functions.GenderHelper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthRequestMapper extends BaseRequestMapper<Auth, AuthRequest> {
    default IdentityDocumentType longToidentityDocumentType(Long id){
        return IdentityDocumentType.builder()
                .id(id)
                .build();
    }

    default Gender mapStringToGender(String name) {
        return GenderHelper.fromName(name);
    }

    @Mapping(source = "idIdentityDocumentType", target = "identityDocumentType")
    User toDomainUser(UserRegisterRequest request);
    Auth toDomainAuth(UserRegisterRequest request);

    default Role fromRoleName(RoleName roleName){
        return Role.builder()
                .name(roleName)
                .build();
    }

    AuthFilter toDomain(AuthFilterRequest request);
}

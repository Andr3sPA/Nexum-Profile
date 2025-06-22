package co.edu.udea.nexum.profile.auth.application.mapper.request;

import co.edu.udea.nexum.profile.auth.application.dto.request.UserRegisterRequest;
import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.user.domain.model.IdentityDocumentType;
import co.edu.udea.nexum.profile.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthRequestMapper {
    default IdentityDocumentType longToidentityDocumentType(Long id){
        return IdentityDocumentType.builder()
                .id(id)
                .build();
    }
    @Mapping(source = "idIdentityDocumentType", target = "identityDocumentType")
    User toDomainUser(UserRegisterRequest request);
    Auth toDomainAuth(UserRegisterRequest request);
}

package co.edu.udea.nexum.profile.user.application.mapper.request;


import co.edu.udea.nexum.profile.common.application.mapper.BaseRequestMapper;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.user.application.dto.request.UserRequest;
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
public interface UserRequestMapper extends BaseRequestMapper<User, UserRequest> {
    default IdentityDocumentType longToidentityDocumentType(Long id){
        return IdentityDocumentType.builder()
                .id(id)
                .build();
    }

    default Gender mapStringToGender(String name) {
        return GenderHelper.fromName(name);
    }

    @Override
    @Mapping(source = "idIdentityDocumentType", target = "identityDocumentType")
    User toDomain(UserRequest entity);
}

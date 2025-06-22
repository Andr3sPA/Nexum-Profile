package co.edu.udea.nexum.profile.auth.application.mapper.response;

import co.edu.udea.nexum.profile.auth.application.dto.response.UserRegisteredResponse;
import co.edu.udea.nexum.profile.common.application.mapper.BaseResponseMapper;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.user.application.dto.response.IdentityDocumentTypeResponse;
import co.edu.udea.nexum.profile.user.domain.model.IdentityDocumentType;
import co.edu.udea.nexum.profile.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRegisteredResponseMapper extends BaseResponseMapper<User, UserRegisteredResponse> {
    default IdentityDocumentTypeResponse identityDocumentTypeResponse(IdentityDocumentType identityDocumentType){
        if(identityDocumentType == null) return null;
        if(identityDocumentType.getDocumentType() == null) return IdentityDocumentTypeResponse.builder()
                .id(identityDocumentType.getId())
                .build();
        return IdentityDocumentTypeResponse.builder()
                .id(identityDocumentType.getId())
                .name(identityDocumentType.getDocumentType().getName())
                .abbreviation(identityDocumentType.getDocumentType().getAbbreviation())
                .build();
    }
}

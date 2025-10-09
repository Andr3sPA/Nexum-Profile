package co.edu.udea.nexum.profile.user.application.mapper.response;


import co.edu.udea.nexum.profile.common.application.dto.response.PageResponse;
import co.edu.udea.nexum.profile.common.application.mapper.BaseResponseMapper;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.pagination.DomainPage;
import co.edu.udea.nexum.profile.user.application.dto.response.IdentityDocumentTypeResponse;
import co.edu.udea.nexum.profile.user.application.dto.response.UserResponse;
import co.edu.udea.nexum.profile.user.application.dto.response.basic.BasicUserResponse;
import co.edu.udea.nexum.profile.user.domain.model.IdentityDocumentType;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.model.basic.BasicUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserResponseMapper extends BaseResponseMapper<User, UserResponse> {

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

    PageResponse<BasicUserResponse> toPageResponse(DomainPage<BasicUser> user);
    BasicUserResponse toBasicResponse(BasicUser basicUser);
}

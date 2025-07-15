package co.edu.udea.nexum.profile.user.application.mapper.response;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.user.application.dto.response.*;
import co.edu.udea.nexum.profile.user.domain.model.aggregate.DetailedUser;
import co.edu.udea.nexum.profile.user.domain.model.IdentityDocumentType;
import co.edu.udea.nexum.profile.user.domain.utils.enums.Gender;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Generated
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface DetailedUserResponseMapper {

    @Mapping(source = "identityDocumentType", target = "identityDocumentType")
    @Mapping(source = "contactInformation", target = "contactInformation")
    @Mapping(source = "familyInformation", target = "familyInformation")
    @Mapping(source = "graduateParticipation", target = "graduateParticipation")
    @Mapping(source = "jobs", target = "jobs")
    @Mapping(source = "coursedPrograms", target = "coursedPrograms")
    @Mapping(source = "academicEducationList", target = "academicEducationList")
    DetailedUserResponse toResponse(DetailedUser detailedUser);

    default IdentityDocumentTypeResponse identityDocumentTypeResponse(IdentityDocumentType identityDocumentType) {
        if (identityDocumentType == null) return null;
        if (identityDocumentType.getDocumentType() == null) return IdentityDocumentTypeResponse.builder()
                .id(identityDocumentType.getId())
                .build();
        return IdentityDocumentTypeResponse.builder()
                .id(identityDocumentType.getId())
                .name(identityDocumentType.getDocumentType().getName())
                .abbreviation(identityDocumentType.getDocumentType().getAbbreviation())
                .build();
    }
}

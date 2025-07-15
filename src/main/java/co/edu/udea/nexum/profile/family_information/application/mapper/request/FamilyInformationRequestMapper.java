package co.edu.udea.nexum.profile.family_information.application.mapper.request;

import co.edu.udea.nexum.profile.common.application.mapper.BaseRequestMapper;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.family_information.application.dto.request.FamilyInformationRequest;
import co.edu.udea.nexum.profile.family_information.domain.model.FamilyInformation;
import co.edu.udea.nexum.profile.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FamilyInformationRequestMapper extends BaseRequestMapper<FamilyInformation, FamilyInformationRequest> {

    default User getUser(UUID userId) {
        return User.builder()
                .id(userId)
                .build();
    }

    @Override
    @Mapping(source = "userId", target = "user")
    FamilyInformation toDomain(FamilyInformationRequest request);
}

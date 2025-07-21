package co.edu.udea.nexum.profile.graduate_participation.application.mapper.request;

import co.edu.udea.nexum.profile.common.application.mapper.BaseRequestMapper;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.graduate_participation.application.dto.request.GraduateParticipationRequest;
import co.edu.udea.nexum.profile.graduate_participation.domain.model.GraduateParticipation;
import co.edu.udea.nexum.profile.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GraduateParticipationRequestMapper extends BaseRequestMapper<GraduateParticipation, GraduateParticipationRequest> {

    default User mapUser(UUID userId) {
        return User.builder().id(userId).build();
    }

    @Override
    @Mapping(source = "userId", target = "user")
    GraduateParticipation toDomain(GraduateParticipationRequest request);
}

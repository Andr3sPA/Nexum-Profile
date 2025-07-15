package co.edu.udea.nexum.profile.graduate_participation.application.mapper.response;

import co.edu.udea.nexum.profile.common.application.mapper.BaseResponseMapper;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.graduate_participation.application.dto.response.GraduateParticipationResponse;
import co.edu.udea.nexum.profile.graduate_participation.domain.model.GraduateParticipation;
import co.edu.udea.nexum.profile.user.application.mapper.response.UserResponseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(
        componentModel = "spring",
        uses = {UserResponseMapper.class},
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface GraduateParticipationResponseMapper extends BaseResponseMapper<GraduateParticipation, GraduateParticipationResponse> {
}

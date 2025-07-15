package co.edu.udea.nexum.profile.innovation_process.application.mapper.response;

import co.edu.udea.nexum.profile.common.application.mapper.BaseResponseMapper;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.innovation_process.application.dto.response.InnovationProcessResponse;
import co.edu.udea.nexum.profile.innovation_process.domain.model.InnovationProcess;
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
public interface InnovationProcessResponseMapper extends BaseResponseMapper<InnovationProcess, InnovationProcessResponse> {
}

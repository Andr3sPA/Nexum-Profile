package co.edu.udea.nexum.profile.job.application.mapper.response;

import co.edu.udea.nexum.profile.common.application.mapper.BaseResponseMapper;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.job.application.dto.response.JobResponse;
import co.edu.udea.nexum.profile.job.domain.model.Job;
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
public interface JobResponseMapper extends BaseResponseMapper<Job, JobResponse> {
}

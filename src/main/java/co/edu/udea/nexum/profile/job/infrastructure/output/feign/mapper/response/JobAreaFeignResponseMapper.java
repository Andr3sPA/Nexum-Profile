package co.edu.udea.nexum.profile.job.infrastructure.output.feign.mapper.response;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.output.feign.mapper.FeignResponseMapper;
import co.edu.udea.nexum.profile.job.domain.model.JobArea;
import co.edu.udea.nexum.profile.job.infrastructure.output.feign.dto.response.JobAreaFeignResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobAreaFeignResponseMapper extends FeignResponseMapper<JobArea, JobAreaFeignResponse> {
}

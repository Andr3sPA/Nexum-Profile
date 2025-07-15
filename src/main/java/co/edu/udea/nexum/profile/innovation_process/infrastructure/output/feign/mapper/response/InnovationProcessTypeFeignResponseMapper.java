package co.edu.udea.nexum.profile.innovation_process.infrastructure.output.feign.mapper.response;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.output.feign.mapper.FeignResponseMapper;
import co.edu.udea.nexum.profile.innovation_process.domain.model.InnovationProcessType;
import co.edu.udea.nexum.profile.innovation_process.infrastructure.output.feign.dto.response.InnovationProcessTypeFeignResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InnovationProcessTypeFeignResponseMapper extends FeignResponseMapper<InnovationProcessType, InnovationProcessTypeFeignResponse> {
}

package co.edu.udea.nexum.profile.coursed_program.infrastructure.output.feign.mapper;


import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.output.feign.mapper.FeignResponseMapper;
import co.edu.udea.nexum.profile.coursed_program.domain.model.ProgramVersion;
import co.edu.udea.nexum.profile.coursed_program.infrastructure.output.feign.dto.response.ProgramVersionFeignResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProgramVersionFeignResponseMapper extends FeignResponseMapper<ProgramVersion, ProgramVersionFeignResponse> {
    @Override
    default ProgramVersion toDomain(ProgramVersionFeignResponse response){
        return ProgramVersion.builder()
                .id(response.getId())
                .name(response.getProgram().getName())
                .version(response.getVersion())
                .build();
    }
}

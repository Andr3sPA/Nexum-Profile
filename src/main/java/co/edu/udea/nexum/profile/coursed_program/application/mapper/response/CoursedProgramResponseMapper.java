package co.edu.udea.nexum.profile.coursed_program.application.mapper.response;

import co.edu.udea.nexum.profile.common.application.mapper.BaseResponseMapper;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.coursed_program.application.dto.response.CoursedProgramResponse;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;
import co.edu.udea.nexum.profile.coursed_program.domain.model.ProgramVersion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CoursedProgramResponseMapper extends BaseResponseMapper<CoursedProgram, CoursedProgramResponse> {
    default Long getProgramVersionId(ProgramVersion programVersion){
        return programVersion.getId();
    }

    @Override
    @Mapping(source = "programVersion", target = "programVersionId")
    CoursedProgramResponse toResponse(CoursedProgram coursedProgram);
}

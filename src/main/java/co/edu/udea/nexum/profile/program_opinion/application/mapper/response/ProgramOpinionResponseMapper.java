package co.edu.udea.nexum.profile.program_opinion.application.mapper.response;

import co.edu.udea.nexum.profile.common.application.mapper.BaseResponseMapper;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;
import co.edu.udea.nexum.profile.program_opinion.application.dto.response.ProgramOpinionResponse;
import co.edu.udea.nexum.profile.program_opinion.domain.model.ProgramOpinion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProgramOpinionResponseMapper extends BaseResponseMapper<ProgramOpinion, ProgramOpinionResponse> {
    default Long getCoursedProgramId(CoursedProgram coursedProgram){
        return coursedProgram.getId();
    }

    @Override
    @Mapping(source = "coursedProgram", target = "coursedProgramId")
    ProgramOpinionResponse toResponse(ProgramOpinion programOpinion);
}

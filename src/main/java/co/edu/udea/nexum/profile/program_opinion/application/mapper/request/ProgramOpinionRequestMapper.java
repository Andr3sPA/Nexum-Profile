package co.edu.udea.nexum.profile.program_opinion.application.mapper.request;

import co.edu.udea.nexum.profile.common.application.mapper.BaseRequestMapper;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;
import co.edu.udea.nexum.profile.program_opinion.application.dto.request.ProgramOpinionRequest;
import co.edu.udea.nexum.profile.program_opinion.domain.model.ProgramOpinion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProgramOpinionRequestMapper extends BaseRequestMapper<ProgramOpinion, ProgramOpinionRequest> {
    default CoursedProgram buildCoursedProgram(Long id) {
        return CoursedProgram.builder()
                .id(id)
                .build();
    }

    @Override
    @Mapping(source = "coursedProgramId", target = "coursedProgram")
    ProgramOpinion toDomain(ProgramOpinionRequest entity);
}

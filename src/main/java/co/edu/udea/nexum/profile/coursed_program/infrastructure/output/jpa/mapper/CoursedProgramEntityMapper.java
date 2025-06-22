package co.edu.udea.nexum.profile.coursed_program.infrastructure.output.jpa.mapper;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;
import co.edu.udea.nexum.profile.coursed_program.domain.model.ProgramVersion;
import co.edu.udea.nexum.profile.coursed_program.infrastructure.output.jpa.entity.CoursedProgramEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CoursedProgramEntityMapper extends BaseEntityMapper<CoursedProgram, CoursedProgramEntity> {
    default Long getProgramVersionId(ProgramVersion programVersion){
        return programVersion.getId();
    }

    default ProgramVersion getProgramVersion(Long programVersionId){
        return ProgramVersion.builder()
                .id(programVersionId)
                .build();
    }

    @Override
    @Mapping(source = "programVersionId", target = "programVersion")
    CoursedProgram toDomain(CoursedProgramEntity coursedProgramEntity);

    @Override
    @Mapping(source = "programVersion", target = "programVersionId")
    CoursedProgramEntity toEntity(CoursedProgram coursedProgram);
}

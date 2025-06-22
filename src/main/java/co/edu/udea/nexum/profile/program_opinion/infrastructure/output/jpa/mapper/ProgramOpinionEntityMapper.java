package co.edu.udea.nexum.profile.program_opinion.infrastructure.output.jpa.mapper;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import co.edu.udea.nexum.profile.program_opinion.domain.model.ProgramOpinion;
import co.edu.udea.nexum.profile.program_opinion.infrastructure.output.jpa.entity.ProgramOpinionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProgramOpinionEntityMapper extends BaseEntityMapper<ProgramOpinion, ProgramOpinionEntity> {
}

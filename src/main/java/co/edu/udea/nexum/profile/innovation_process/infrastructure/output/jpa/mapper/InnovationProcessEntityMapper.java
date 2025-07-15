package co.edu.udea.nexum.profile.innovation_process.infrastructure.output.jpa.mapper;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import co.edu.udea.nexum.profile.innovation_process.domain.model.InnovationProcess;
import co.edu.udea.nexum.profile.innovation_process.domain.model.InnovationProcessType;
import co.edu.udea.nexum.profile.innovation_process.infrastructure.output.jpa.entity.InnovationProcessEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface InnovationProcessEntityMapper extends BaseEntityMapper<InnovationProcess, InnovationProcessEntity> {

    @Mapping(source = "type.id", target = "type")
    InnovationProcessEntity toEntity(InnovationProcess domain);

    @Mapping(target = "type", source = "type")
    InnovationProcess toDomain(InnovationProcessEntity entity);

    default InnovationProcessType typeFromId(Long id) {
        return id == null ? null : InnovationProcessType.builder().id(id).build();
    }

    default Long typeToId(InnovationProcessType type) {
        return type != null ? type.getId() : null;
    }
}

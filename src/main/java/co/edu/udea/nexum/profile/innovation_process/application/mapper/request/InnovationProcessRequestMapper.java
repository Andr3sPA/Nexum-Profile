package co.edu.udea.nexum.profile.innovation_process.application.mapper.request;

import co.edu.udea.nexum.profile.common.application.mapper.BaseRequestMapper;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.innovation_process.application.dto.request.InnovationProcessRequest;
import co.edu.udea.nexum.profile.innovation_process.domain.model.InnovationProcess;
import co.edu.udea.nexum.profile.innovation_process.domain.model.InnovationProcessType;
import co.edu.udea.nexum.profile.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

@Generated
@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface InnovationProcessRequestMapper extends BaseRequestMapper<InnovationProcess, InnovationProcessRequest> {

    default User mapUser(UUID id) {
        return User.builder().id(id).build();
    }

    default InnovationProcessType mapType(Long id) {
        return id == null ? null : InnovationProcessType.builder().id(id).build();
    }

    @Override
    @Mapping(source = "userId", target = "user")
    @Mapping(source = "typeId", target = "type")
    InnovationProcess toDomain(InnovationProcessRequest request);
}

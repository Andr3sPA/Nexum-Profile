package co.edu.udea.nexum.profile.coursed_program.application.mapper.request;

import co.edu.udea.nexum.profile.common.application.mapper.BaseRequestMapper;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.coursed_program.application.dto.request.CoursedProgramRequest;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;
import co.edu.udea.nexum.profile.coursed_program.domain.model.ProgramVersion;
import co.edu.udea.nexum.profile.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CoursedProgramRequestMapper extends BaseRequestMapper<CoursedProgram, CoursedProgramRequest> {
    default User getUser(UUID userId) {
        return User.builder()
                .id(userId)
                .build();
    }

    default ProgramVersion getProgramVersion(Long programVersionId) {
        return ProgramVersion.builder()
                .id(programVersionId)
                .build();
    }

    @Override
    @Mapping(source = "userId", target = "user")
    @Mapping(source = "programVersionId", target = "programVersion")
    CoursedProgram toDomain(CoursedProgramRequest entity);
}

package co.edu.udea.nexum.profile.job.application.mapper.request;

import co.edu.udea.nexum.profile.common.application.mapper.BaseRequestMapper;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.job.application.dto.request.JobRequest;
import co.edu.udea.nexum.profile.job.domain.model.*;
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
public interface JobRequestMapper extends BaseRequestMapper<Job, JobRequest> {

    default User mapUser(UUID userId) {
        return User.builder().id(userId).build();
    }

    default SalaryRange mapSalaryRange(Long id) {
        return id != null ? SalaryRange.builder().id(id).build() : null;
    }

    default JobDelay mapJobDelay(Long id) {
        return id != null ? JobDelay.builder().id(id).build() : null;
    }

    default JobArea mapJobArea(Long id) {
        return id != null ? JobArea.builder().id(id).build() : null;
    }

    default JobInstitutionType mapInstitutionType(Long id) {
        return id != null ? JobInstitutionType.builder().id(id).build() : null;
    }

    @Override
    @Mapping(source = "userId", target = "user")
    @Mapping(source = "salaryRangeId", target = "salaryRange")
    @Mapping(source = "jobDelayId", target = "jobDelay")
    @Mapping(source = "jobAreaId", target = "jobArea")
    @Mapping(source = "institutionTypeId", target = "institutionType")
    Job toDomain(JobRequest request);
}

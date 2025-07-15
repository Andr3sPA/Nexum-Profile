package co.edu.udea.nexum.profile.job.infrastructure.output.jpa.mapper;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import co.edu.udea.nexum.profile.job.domain.model.*;
import co.edu.udea.nexum.profile.job.infrastructure.output.jpa.entity.JobEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface JobEntityMapper extends BaseEntityMapper<Job, JobEntity> {

    @Mapping(source = "salaryRange.id", target = "salaryRangeId")
    @Mapping(source = "jobDelay.id", target = "jobDelayId")
    @Mapping(source = "jobArea.id", target = "jobAreaId")
    @Mapping(source = "institutionType.id", target = "institutionTypeId")
    JobEntity toEntity(Job domain);

    @Mapping(target = "salaryRange", source = "salaryRangeId")
    @Mapping(target = "jobDelay", source = "jobDelayId")
    @Mapping(target = "jobArea", source = "jobAreaId")
    @Mapping(target = "institutionType", source = "institutionTypeId")
    Job toDomain(JobEntity entity);

    default SalaryRange salaryRangeFromId(Long id) {
        return id == null ? null : SalaryRange.builder().id(id).build();
    }

    default Long salaryRangeToId(SalaryRange salaryRange) {
        return salaryRange != null ? salaryRange.getId() : null;
    }

    default JobDelay jobDelayFromId(Long id) {
        return id == null ? null : JobDelay.builder().id(id).build();
    }

    default Long jobDelayToId(JobDelay jobDelay) {
        return jobDelay != null ? jobDelay.getId() : null;
    }

    default JobArea jobAreaFromId(Long id) {
        return id == null ? null : JobArea.builder().id(id).build();
    }

    default Long jobAreaToId(JobArea jobArea) {
        return jobArea != null ? jobArea.getId() : null;
    }

    default JobInstitutionType institutionTypeFromId(Long id) {
        return id == null ? null : JobInstitutionType.builder().id(id).build();
    }

    default Long institutionTypeToId(JobInstitutionType institutionType) {
        return institutionType != null ? institutionType.getId() : null;
    }

}
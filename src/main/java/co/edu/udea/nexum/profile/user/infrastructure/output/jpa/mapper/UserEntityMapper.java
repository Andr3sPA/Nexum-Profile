package co.edu.udea.nexum.profile.user.infrastructure.output.jpa.mapper;

import co.edu.udea.nexum.profile.academic_education.domain.model.AcademicEducation;
import co.edu.udea.nexum.profile.academic_education.infrastructure.output.jpa.entity.AcademicEducationEntity;
import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.entity.AuthEntity;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.pagination.DomainPage;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import co.edu.udea.nexum.profile.contact_information.domain.model.ContactInformation;
import co.edu.udea.nexum.profile.contact_information.infrastructure.output.jpa.entity.ContactInformationEntity;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;
import co.edu.udea.nexum.profile.coursed_program.domain.model.ProgramVersion;
import co.edu.udea.nexum.profile.coursed_program.infrastructure.output.jpa.entity.CoursedProgramEntity;
import co.edu.udea.nexum.profile.innovation_process.domain.model.InnovationProcess;
import co.edu.udea.nexum.profile.innovation_process.domain.model.InnovationProcessType;
import co.edu.udea.nexum.profile.innovation_process.infrastructure.output.jpa.entity.InnovationProcessEntity;
import co.edu.udea.nexum.profile.job.domain.model.*;
import co.edu.udea.nexum.profile.job.infrastructure.output.jpa.entity.JobEntity;
import co.edu.udea.nexum.profile.user.domain.model.IdentityDocumentType;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.model.full.FullUser;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.entity.FullUserEntity;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import java.util.List;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper extends BaseEntityMapper<User, UserEntity> {
    default Long idIdentDocumentType(IdentityDocumentType identityDocumentType) {
        return identityDocumentType.getId();
    }

    default IdentityDocumentType identityDocumentType(Long idIdentDocumentType) {
        return IdentityDocumentType.builder()
                .id(idIdentDocumentType)
                .build();
    }

    @Override
    @Mapping(source = "idIdentityDocumentType", target = "identityDocumentType")
    User toDomain(UserEntity userEntity);

    @Override
    @Mapping(source = "identityDocumentType", target = "idIdentityDocumentType")
    UserEntity toEntity(User user);

    @Mapping(target = "page", source = "number")
    @Mapping(target = "pageSize", source = "size")
    @Mapping(target = "totalPages", source = "totalPages")
    @Mapping(target = "count", source = "numberOfElements")
    @Mapping(target = "totalCount", source = "totalElements")
    @Mapping(target = "content", source = "content")
    DomainPage<FullUser> toDomainPage(Page<FullUserEntity> page);


    List<FullUser> toFullDomain(List<FullUserEntity> page);

    default InnovationProcessType toInnovationProcess(Long id) {
        return InnovationProcessType.builder()
                .id(id)
                .build();
    }

    default ProgramVersion toProgramVersion(Long id) {
        return ProgramVersion.builder()
                .id(id)
                .build();
    }

    default SalaryRange salaryRangeFromId(Long id) {
        return id == null ? null : SalaryRange.builder().id(id).build();
    }

    default JobDelay jobDelayFromId(Long id) {
        return id == null ? null : JobDelay.builder().id(id).build();
    }

    default JobArea jobAreaFromId(Long id) {
        return id == null ? null : JobArea.builder().id(id).build();
    }

    default JobInstitutionType institutionTypeFromId(Long id) {
        return id == null ? null : JobInstitutionType.builder().id(id).build();
    }

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "jobDelay", source = "jobDelayId")
    @Mapping(target = "jobArea", source = "jobAreaId")
    @Mapping(target = "institutionType", source = "institutionTypeId")
    @Mapping(target = "salaryRange", source = "salaryRangeId")
    Job toJob(JobEntity jobEntity);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "programVersion", source = "programVersionId")
    CoursedProgram coursedPrograms(CoursedProgramEntity coursedProgramEntity);

    @Mapping(target = "user", ignore = true)
    ContactInformation contactInformationList(ContactInformationEntity contactInformationEntity);

    @Mapping(target = "user", ignore = true)
    AcademicEducation academicEducationList(AcademicEducationEntity academicEducationEntity);

    @Mapping(target = "user", ignore = true)
    InnovationProcess innovationProcesses(InnovationProcessEntity innovationProcessEntity);

    @Mapping(target = "user", ignore = true)
    Auth auth(AuthEntity authEntity);
}

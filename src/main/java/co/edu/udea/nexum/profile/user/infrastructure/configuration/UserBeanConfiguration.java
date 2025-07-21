package co.edu.udea.nexum.profile.user.infrastructure.configuration;

import co.edu.udea.nexum.profile.academic_education.domain.spi.AcademicEducationPersistencePort;
import co.edu.udea.nexum.profile.auth.domain.spi.persistence.AuthPersistencePort;
import co.edu.udea.nexum.profile.auth.domain.spi.security.AuthenticationSecurityPort;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.contact_information.domain.spi.ContactInformationPersistencePort;
import co.edu.udea.nexum.profile.coursed_program.domain.spi.CoursedProgramPersistencePort;
import co.edu.udea.nexum.profile.coursed_program.domain.spi.ProgramVersionPersistencePort;
import co.edu.udea.nexum.profile.family_information.domain.spi.FamilyInformationPersistencePort;
import co.edu.udea.nexum.profile.graduate_participation.domain.spi.GraduateParticipationPersistencePort;
import co.edu.udea.nexum.profile.innovation_process.domain.spi.InnovationProcessPersistencePort;
import co.edu.udea.nexum.profile.innovation_process.domain.spi.InnovationProcessTypePersistencePort;
import co.edu.udea.nexum.profile.job.domain.spi.*;
import co.edu.udea.nexum.profile.user.domain.api.DetailedUserServicePort;
import co.edu.udea.nexum.profile.user.domain.api.UserServicePort;
import co.edu.udea.nexum.profile.user.domain.spi.IdentityDocumentTypePersistencePort;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;
import co.edu.udea.nexum.profile.user.domain.usecase.DetailedUserServiceImpl;
import co.edu.udea.nexum.profile.user.domain.usecase.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Generated
@Configuration
public class UserBeanConfiguration {
    @Bean
    public UserServicePort userServicePort(
            UserPersistencePort userPersistencePort,
            IdentityDocumentTypePersistencePort identityDocumentTypePersistencePort,
            AuthenticationSecurityPort authenticationSecurityPort,
            ProgramVersionPersistencePort programVersionPersistencePort,
            AuthPersistencePort authPersistencePort
    ) {
        return new UserUseCase(
                userPersistencePort,
                identityDocumentTypePersistencePort,
                authenticationSecurityPort,
                programVersionPersistencePort,
                authPersistencePort

        );
    }

    @Bean
    public DetailedUserServicePort userDetailedServicePort(
            UserPersistencePort userPersistencePort,
            JobPersistencePort jobPersistencePort,
            ContactInformationPersistencePort contactInformationPersistencePort,
            FamilyInformationPersistencePort familyInformationPersistencePort,
            GraduateParticipationPersistencePort graduateParticipationPersistencePort,
            CoursedProgramPersistencePort coursedProgramPersistencePort,
            AcademicEducationPersistencePort academicEducationPersistencePort,
            SalaryRangePersistencePort salaryRangeServicePort,
            JobDelayPersistencePort jobDelayServicePort,
            JobAreaPersistencePort jobAreaServicePort,
            JobInstitutionTypePersistencePort jobInstitutionTypeServicePort,
            InnovationProcessPersistencePort innovationProcessPersistencePort,
            InnovationProcessTypePersistencePort innovationProcessTypePersistencePort,
            ProgramVersionPersistencePort programVersionServicePort,
            IdentityDocumentTypePersistencePort identityDocumentTypePersistencePort,
            AuthenticationSecurityPort authenticationSecurityPort,
            AuthPersistencePort authPersistencePort
    ) {
        return DetailedUserServiceImpl.builder()
                .userPersistencePort(userPersistencePort)
                .jobPersistencePort(jobPersistencePort)
                .contactInformationPersistencePort(contactInformationPersistencePort)
                .familyInformationPersistencePort(familyInformationPersistencePort)
                .graduateParticipationPersistencePort(graduateParticipationPersistencePort)
                .coursedProgramPersistencePort(coursedProgramPersistencePort)
                .academicEducationPersistencePort(academicEducationPersistencePort)
                .salaryRangePersistencePort(salaryRangeServicePort)
                .jobDelayPersistencePort(jobDelayServicePort)
                .jobAreaPersistencePort(jobAreaServicePort)
                .jobInstitutionTypePersistencePort(jobInstitutionTypeServicePort)
                .innovationProcessPersistencePort(innovationProcessPersistencePort)
                .innovationProcessTypePersistencePort(innovationProcessTypePersistencePort)
                .programVersionPersistencePort(programVersionServicePort)
                .authenticationSecurityPort(authenticationSecurityPort)
                .identityDocumentTypePersistencePort(identityDocumentTypePersistencePort)
                .authPersistencePort(authPersistencePort)
                .build();
    }
}
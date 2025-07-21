package co.edu.udea.nexum.profile.academic_education.infrastructure.configuration;

import co.edu.udea.nexum.profile.academic_education.domain.api.AcademicEducationServicePort;
import co.edu.udea.nexum.profile.academic_education.domain.spi.AcademicEducationPersistencePort;
import co.edu.udea.nexum.profile.academic_education.domain.usecase.AcademicEducationUseCase;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Generated
@Configuration
public class AcademicEducationConfigurationBean {

    @Bean
    public AcademicEducationServicePort academicEducationServicePort(
            AcademicEducationPersistencePort academicEducationPersistencePort,
            UserPersistencePort userPersistencePort
    ) {
        return new AcademicEducationUseCase(
                academicEducationPersistencePort,
                userPersistencePort
        );
    }
}

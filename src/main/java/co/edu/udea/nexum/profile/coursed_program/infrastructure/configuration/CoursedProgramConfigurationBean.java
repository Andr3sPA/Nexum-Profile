package co.edu.udea.nexum.profile.coursed_program.infrastructure.configuration;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.coursed_program.domain.api.CoursedProgramServicePort;
import co.edu.udea.nexum.profile.coursed_program.domain.spi.CoursedProgramPersistencePort;
import co.edu.udea.nexum.profile.coursed_program.domain.spi.ProgramVersionPersistencePort;
import co.edu.udea.nexum.profile.coursed_program.domain.usecase.CoursedProgramUseCase;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Generated
@Configuration
public class CoursedProgramConfigurationBean {
    @Bean
    CoursedProgramServicePort coursedProgramServicePort(
            CoursedProgramPersistencePort coursedProgramPersistencePort,
            UserPersistencePort userPersistencePort,
            ProgramVersionPersistencePort programVersionPersistencePort) {
        return new CoursedProgramUseCase(
                coursedProgramPersistencePort,
                userPersistencePort,
                programVersionPersistencePort);
    }
}

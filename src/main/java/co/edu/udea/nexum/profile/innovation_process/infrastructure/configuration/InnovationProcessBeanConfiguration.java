package co.edu.udea.nexum.profile.innovation_process.infrastructure.configuration;

import co.edu.udea.nexum.profile.innovation_process.domain.api.InnovationProcessServicePort;
import co.edu.udea.nexum.profile.innovation_process.domain.spi.InnovationProcessPersistencePort;
import co.edu.udea.nexum.profile.innovation_process.domain.spi.InnovationProcessTypePersistencePort;
import co.edu.udea.nexum.profile.innovation_process.domain.usecase.InnovationProcessUseCase;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InnovationProcessBeanConfiguration {

    @Bean
InnovationProcessServicePort innovationProcessServicePort(
            InnovationProcessPersistencePort innovationProcessPersistencePort,
            InnovationProcessTypePersistencePort innovationProcessTypePersistencePort,
            UserPersistencePort userPersistencePort
    ) {
        return new InnovationProcessUseCase(
                innovationProcessPersistencePort,
                userPersistencePort,
                innovationProcessTypePersistencePort
        );
    }
}

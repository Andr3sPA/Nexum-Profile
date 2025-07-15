package co.edu.udea.nexum.profile.graduate_participation.infrastructure.configuration;

import co.edu.udea.nexum.profile.graduate_participation.domain.api.GraduateParticipationServicePort;
import co.edu.udea.nexum.profile.graduate_participation.domain.spi.GraduateParticipationPersistencePort;
import co.edu.udea.nexum.profile.graduate_participation.domain.usecase.GraduateParticipationUseCase;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraduateParticipationBeanConfiguration {

    @Bean
    public GraduateParticipationServicePort graduateParticipationServicePort(
            GraduateParticipationPersistencePort graduateParticipationPersistencePort,
            UserPersistencePort userPersistencePort
    ) {
        return new GraduateParticipationUseCase(
                graduateParticipationPersistencePort,
                userPersistencePort
        );
    }
}

package co.edu.udea.nexum.profile.family_information.infrastructure.configuration;

import co.edu.udea.nexum.profile.family_information.domain.api.FamilyInformationServicePort;
import co.edu.udea.nexum.profile.family_information.domain.spi.FamilyInformationPersistencePort;
import co.edu.udea.nexum.profile.family_information.domain.usecase.FamilyInformationUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FamilyInformationBeanConfiguration {
    @Bean
    public FamilyInformationServicePort familyInformationServicePort(
            FamilyInformationPersistencePort familyInformationPersistencePort
    ) {
        return new FamilyInformationUseCase(
                familyInformationPersistencePort
        );
    }
}

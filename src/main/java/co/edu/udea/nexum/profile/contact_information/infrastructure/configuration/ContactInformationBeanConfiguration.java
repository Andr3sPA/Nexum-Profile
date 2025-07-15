package co.edu.udea.nexum.profile.contact_information.infrastructure.configuration;

import co.edu.udea.nexum.profile.auth.domain.spi.security.AuthenticationSecurityPort;
import co.edu.udea.nexum.profile.contact_information.domain.api.ContactInformationServicePort;
import co.edu.udea.nexum.profile.contact_information.domain.spi.ContactInformationPersistencePort;
import co.edu.udea.nexum.profile.contact_information.domain.usecase.ContactInformationUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContactInformationBeanConfiguration {
    @Bean
    public ContactInformationServicePort contactInformationServicePort(
            ContactInformationPersistencePort contactInformationPersistencePort
    ) {
        return new ContactInformationUseCase(
                contactInformationPersistencePort
        );
    }
}

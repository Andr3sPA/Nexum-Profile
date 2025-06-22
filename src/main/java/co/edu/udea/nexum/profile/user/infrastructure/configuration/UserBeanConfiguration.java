package co.edu.udea.nexum.profile.user.infrastructure.configuration;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.user.domain.api.UserServicePort;
import co.edu.udea.nexum.profile.user.domain.spi.IdentityDocumentTypePersistencePort;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;
import co.edu.udea.nexum.profile.user.domain.usecase.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Generated
@Configuration
public class UserBeanConfiguration {
    @Bean
    public UserServicePort userServicePort(
            UserPersistencePort userPersistencePort,
            IdentityDocumentTypePersistencePort identityDocumentTypePersistencePort
    ) {
        return new UserUseCase(
                userPersistencePort,
                identityDocumentTypePersistencePort
        );
    }
}
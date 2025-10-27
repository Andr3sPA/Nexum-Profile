package co.edu.udea.nexum.profile.auth.infrastructure.configuration.bean;

import co.edu.udea.nexum.profile.auth.domain.api.AuthCrudServicePort;
import co.edu.udea.nexum.profile.auth.domain.api.AuthServicePort;
import co.edu.udea.nexum.profile.auth.domain.api.TokenServicePort;
import co.edu.udea.nexum.profile.auth.domain.spi.email.EmailServicePort;
import co.edu.udea.nexum.profile.auth.domain.spi.persistence.AuthPersistencePort;
import co.edu.udea.nexum.profile.auth.domain.spi.persistence.RolePersistencePort;
import co.edu.udea.nexum.profile.auth.domain.spi.security.AuthenticationSecurityPort;
import co.edu.udea.nexum.profile.auth.domain.spi.security.TokenSecurityPort;
import co.edu.udea.nexum.profile.auth.domain.usecase.AuthCrudUseCase;
import co.edu.udea.nexum.profile.auth.domain.usecase.AuthUseCase;
import co.edu.udea.nexum.profile.auth.domain.usecase.TokenUseCase;
import co.edu.udea.nexum.profile.user.domain.spi.IdentityDocumentTypePersistencePort;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthBeanConfiguration {
    @Bean
    AuthServicePort authServicePort(
            AuthPersistencePort authPersistencePort,
            AuthenticationSecurityPort authenticationSecurityPort,
            RolePersistencePort rolePersistencePort,
            UserPersistencePort userPersistencePort,
            IdentityDocumentTypePersistencePort identityDocumentTypePersistencePort,
            EmailServicePort emailServicePort,
            PasswordEncoder passwordEncoder) {
        return new AuthUseCase(
                authPersistencePort,
                authenticationSecurityPort,
                rolePersistencePort,
                userPersistencePort,
                identityDocumentTypePersistencePort,
                emailServicePort,
                passwordEncoder);
    }

    @Bean
    TokenServicePort tokenServicePort(
            TokenSecurityPort tokenSecurityPort,
            AuthPersistencePort authPersistencePort) {
        return new TokenUseCase(
                tokenSecurityPort,
                authPersistencePort);
    }

    @Bean
    AuthCrudServicePort authCrudServicePort(
            AuthPersistencePort authPersistencePort,
            RolePersistencePort rolePersistencePort) {
        return new AuthCrudUseCase(
                authPersistencePort,
                rolePersistencePort);
    }
}

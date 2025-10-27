package co.edu.udea.nexum.profile.security.infrastructure.configuration;

import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.domain.spi.persistence.AuthPersistencePort;
import co.edu.udea.nexum.profile.auth.domain.spi.security.AuthenticationSecurityPort;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.entity.AuthEntity;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.repository.AuthRepository;
import co.edu.udea.nexum.profile.common.domain.exception.EntityNotFoundException;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.security.domain.utils.helpers.SecurityHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.UUID;

import static co.edu.udea.nexum.profile.common.infrastructure.utils.constants.ConfigurationConstants.ROLE_PREFIX;

@Configuration
@Generated
public class SecurityBeanConfiguration {
    // Security
    @Bean
PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService(AuthRepository authServicePort) {
        return username -> {
            AuthEntity domainUser = authServicePort.findById(UUID.fromString(username)).orElse(null);
            if (domainUser == null) throw new EntityNotFoundException(Auth.class.getSimpleName());
            return new org.springframework.security.core.userdetails.User(
                    domainUser.getId().toString(),
                    domainUser.getPassword(),
                    List.of(new SimpleGrantedAuthority(ROLE_PREFIX + domainUser.getRole().getName().name()))
            );
        };
    }

    @Bean
    AuthenticationProvider authenticationProvider(
            PasswordEncoder passwordEncoder,
            UserDetailsService userDetailsService
    ) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
SecurityHelper.SecurityHelperConfigurator securityHelperInitializer(
            AuthenticationSecurityPort authenticationSecurityPort,
            AuthPersistencePort authPersistencePort
    ) {
        return SecurityHelper.configure()
                .authenticationSecurityHelper(authenticationSecurityPort)
                .authPersistencePort(authPersistencePort)
                .done();
    }
}

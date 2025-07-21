package co.edu.udea.nexum.profile.utils;

import co.edu.udea.nexum.profile.auth.application.dto.request.UserRegisterRequest;
import co.edu.udea.nexum.profile.auth.application.handler.AuthHandler;
import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.entity.RoleEntity;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.repository.RoleRepository;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Slf4j
@Generated
@Configuration
@RequiredArgsConstructor
public class DataInitializer {
    private final RoleRepository roleRepository;
    private final AuthHandler authHandler;

    @Bean
    public CommandLineRunner init() {
        return args -> {
            if (roleRepository.count() > 0) return;

            log.info(INITIALIZING_DATA);

            Arrays.stream(RoleName.values()).forEach(name -> {
                log.info(CREATING_ROLE_LOG_MESSAGE, name);
                roleRepository.save(RoleEntity.builder()
                        .name(name)
                        .build());
            });

            initializeEntities();
        };
    }

    private void initializeEntities() {
        initializeMockAdmin();
    }

    private void initializeMockAdmin(){
        authHandler.registerAdministrative(
                UserRegisterRequest.builder()
                        .name("Nexum")
                        .lastname("Admin")
                        .secondLastname("Admin")
                        .email("admin@nexum.com")
                        .password("password") // NOSONAR
                        .birthdate(LocalDate.now().minusYears(20L))
                        .identityDocument("0000000000")
                        .idIdentityDocumentType(1L)
                        .gender("otro")
                        .build()
        );
    }

    public static final String INITIALIZING_DATA = "Initializing data ...";
    public static final String CREATING_ROLE_LOG_MESSAGE = "Creating role type {}";
}

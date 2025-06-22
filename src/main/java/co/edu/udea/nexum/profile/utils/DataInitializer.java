package co.edu.udea.nexum.profile.utils;

import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.entity.RoleEntity;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.repository.RoleRepository;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Slf4j
@Generated
@Configuration
@RequiredArgsConstructor
public class DataInitializer {
    private final RoleRepository roleRepository;

    @Bean
    public CommandLineRunner init() {
        return args -> {
            if (roleRepository.count() > 0) return;

            log.info(INITIALIZING_DATA);

            Arrays.stream(RoleName.values()).forEach(name -> {
                log.info(CREATING_IDENTITY_DOCUMENT_TYPE_LOG_MESSAGE, name);
                roleRepository.save(RoleEntity.builder()
                        .name(name)
                        .build());
            });

            initializeEntities();
        };
    }

    private void initializeEntities() {
    }

    public static final String INITIALIZING_DATA = "Initializing data ...";
    public static final String CREATING_IDENTITY_DOCUMENT_TYPE_LOG_MESSAGE = "Creating identity document type {}";
}

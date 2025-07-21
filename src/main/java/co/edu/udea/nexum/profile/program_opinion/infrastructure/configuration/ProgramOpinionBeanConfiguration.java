package co.edu.udea.nexum.profile.program_opinion.infrastructure.configuration;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.coursed_program.domain.spi.CoursedProgramPersistencePort;
import co.edu.udea.nexum.profile.program_opinion.domain.api.ProgramOpinionServicePort;
import co.edu.udea.nexum.profile.program_opinion.domain.spi.ProgramOpinionPersistencePort;
import co.edu.udea.nexum.profile.program_opinion.domain.usecase.ProgramOpinionUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Generated
@Configuration
public class ProgramOpinionBeanConfiguration {
    @Bean
    public ProgramOpinionServicePort programOpinionServicePort(
            ProgramOpinionPersistencePort programOpinionPersistencePort,
            CoursedProgramPersistencePort coursedProgramPersistencePort
    ) {
        return new ProgramOpinionUseCase(
                programOpinionPersistencePort,
                coursedProgramPersistencePort
        );
    }
}

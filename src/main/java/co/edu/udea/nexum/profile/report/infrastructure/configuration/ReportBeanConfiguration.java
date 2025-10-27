package co.edu.udea.nexum.profile.report.infrastructure.configuration;

import co.edu.udea.nexum.profile.coursed_program.domain.spi.ProgramVersionPersistencePort;
import co.edu.udea.nexum.profile.report.domain.api.ReportServicePort;
import co.edu.udea.nexum.profile.report.domain.spi.ReportGenerationPort;
import co.edu.udea.nexum.profile.report.domain.usecase.ReportUseCase;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReportBeanConfiguration {

    @Bean
    ReportServicePort reportServicePort(
            UserPersistencePort userPersistencePort,
            ReportGenerationPort reportGenerationPort,
            ProgramVersionPersistencePort programVersionPersistencePort) {
        return new ReportUseCase(
                userPersistencePort,
                reportGenerationPort,
                programVersionPersistencePort);
    }
}

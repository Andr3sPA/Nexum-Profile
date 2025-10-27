package co.edu.udea.nexum.profile.job.infrastructure.configuration;

import co.edu.udea.nexum.profile.job.domain.api.JobServicePort;
import co.edu.udea.nexum.profile.job.domain.spi.*;
import co.edu.udea.nexum.profile.job.domain.usecase.JobUseCase;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobBeanConfiguration {

    @Bean
    JobServicePort jobServicePort(
            JobPersistencePort jobPersistencePort,
            UserPersistencePort userPersistencePort,
            SalaryRangePersistencePort salaryRangePersistencePort,
            JobDelayPersistencePort jobDelayPersistencePort,
            JobAreaPersistencePort jobAreaPersistencePort,
            JobInstitutionTypePersistencePort institutionTypePersistencePort) {
        return new JobUseCase(
                jobPersistencePort,
                userPersistencePort,
                salaryRangePersistencePort,
                jobDelayPersistencePort,
                jobAreaPersistencePort,
                institutionTypePersistencePort);
    }
}

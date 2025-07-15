package co.edu.udea.nexum.profile.job.domain.spi;

import co.edu.udea.nexum.profile.job.domain.model.JobDelay;

public interface JobDelayPersistencePort {
    JobDelay findById(Long id);
}

package co.edu.udea.nexum.profile.job.domain.spi;

import co.edu.udea.nexum.profile.job.domain.model.JobArea;

public interface JobAreaPersistencePort {
    JobArea findById(Long id);
}

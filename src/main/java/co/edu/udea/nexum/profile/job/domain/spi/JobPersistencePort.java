package co.edu.udea.nexum.profile.job.domain.spi;

import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.job.domain.model.Job;

import java.util.List;
import java.util.UUID;

public interface JobPersistencePort extends BaseCrudPersistencePort<Long, Job> {
    List<Job> findByUserId(UUID userId);
    Job findFirstByUserId(UUID id);

    Job findCurrentByUserId(UUID userId);
}

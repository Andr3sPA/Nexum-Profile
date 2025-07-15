package co.edu.udea.nexum.profile.job.domain.api;

import co.edu.udea.nexum.profile.common.domain.api.BaseCrudServicePort;
import co.edu.udea.nexum.profile.job.domain.model.Job;

import java.util.List;
import java.util.UUID;

public interface JobServicePort extends BaseCrudServicePort<Long, Job> {
    List<Job> findByUserId(UUID userId);
}

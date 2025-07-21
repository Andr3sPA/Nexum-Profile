package co.edu.udea.nexum.profile.innovation_process.domain.api;

import co.edu.udea.nexum.profile.common.domain.api.BaseCrudServicePort;
import co.edu.udea.nexum.profile.innovation_process.domain.model.InnovationProcess;

import java.util.List;
import java.util.UUID;

public interface InnovationProcessServicePort extends BaseCrudServicePort<Long, InnovationProcess> {
    List<InnovationProcess> findByUserId(UUID userId);
}

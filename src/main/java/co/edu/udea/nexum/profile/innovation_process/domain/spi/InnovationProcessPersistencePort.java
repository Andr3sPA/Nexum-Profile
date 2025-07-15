package co.edu.udea.nexum.profile.innovation_process.domain.spi;

import co.edu.udea.nexum.profile.innovation_process.domain.model.InnovationProcess;
import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;

import java.util.List;
import java.util.UUID;

public interface InnovationProcessPersistencePort extends BaseCrudPersistencePort<Long, InnovationProcess> {
    List<InnovationProcess> findByUserId(UUID userId);
}

package co.edu.udea.nexum.profile.innovation_process.domain.spi;

import co.edu.udea.nexum.profile.innovation_process.domain.model.InnovationProcessType;

import java.util.List;

public interface InnovationProcessTypePersistencePort {
    InnovationProcessType findById(Long id);
    List<InnovationProcessType> findByIds(List<Long> ids);
}

package co.edu.udea.nexum.profile.job.domain.spi;

import co.edu.udea.nexum.profile.job.domain.model.JobInstitutionType;

public interface JobInstitutionTypePersistencePort {
    JobInstitutionType findById(Long id);
}

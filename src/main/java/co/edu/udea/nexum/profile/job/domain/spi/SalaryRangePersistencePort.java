package co.edu.udea.nexum.profile.job.domain.spi;


import co.edu.udea.nexum.profile.job.domain.model.SalaryRange;

public interface SalaryRangePersistencePort {
    SalaryRange findById(Long id);
}

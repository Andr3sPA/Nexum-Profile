package co.edu.udea.nexum.profile.academic_education.domain.spi;

import co.edu.udea.nexum.profile.academic_education.domain.model.AcademicEducation;
import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;

import java.util.List;
import java.util.UUID;

public interface AcademicEducationPersistencePort extends BaseCrudPersistencePort<Long, AcademicEducation> {
    List<AcademicEducation> findAllByUserId(UUID id);
}

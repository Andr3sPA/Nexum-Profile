package co.edu.udea.nexum.profile.coursed_program.domain.spi;

import co.edu.udea.nexum.profile.coursed_program.domain.model.ProgramVersion;

public interface ProgramVersionPersistencePort {
    ProgramVersion findById(Long id);
}

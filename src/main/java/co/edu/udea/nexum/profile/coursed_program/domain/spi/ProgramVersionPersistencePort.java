package co.edu.udea.nexum.profile.coursed_program.domain.spi;

import co.edu.udea.nexum.profile.coursed_program.domain.model.ProgramVersion;
import co.edu.udea.nexum.profile.coursed_program.domain.model.aggregate.FullProgramVersion;

import java.util.List;

public interface ProgramVersionPersistencePort {
    ProgramVersion findById(Long id);
    List<FullProgramVersion> findAll();
}

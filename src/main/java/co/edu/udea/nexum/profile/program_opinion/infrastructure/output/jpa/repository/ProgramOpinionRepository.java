package co.edu.udea.nexum.profile.program_opinion.infrastructure.output.jpa.repository;

import co.edu.udea.nexum.profile.program_opinion.infrastructure.output.jpa.entity.ProgramOpinionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramOpinionRepository extends JpaRepository<ProgramOpinionEntity, Long> {
}

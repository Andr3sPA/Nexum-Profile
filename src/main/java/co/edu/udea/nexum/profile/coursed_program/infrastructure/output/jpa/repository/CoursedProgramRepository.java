package co.edu.udea.nexum.profile.coursed_program.infrastructure.output.jpa.repository;

import co.edu.udea.nexum.profile.coursed_program.infrastructure.output.jpa.entity.CoursedProgramEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CoursedProgramRepository extends JpaRepository<CoursedProgramEntity, Long> {
    List<CoursedProgramEntity> findAllByUser_Id(UUID userId);
}

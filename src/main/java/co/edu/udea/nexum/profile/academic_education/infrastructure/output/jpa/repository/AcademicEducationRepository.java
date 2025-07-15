package co.edu.udea.nexum.profile.academic_education.infrastructure.output.jpa.repository;

import co.edu.udea.nexum.profile.academic_education.infrastructure.output.jpa.entity.AcademicEducationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AcademicEducationRepository extends JpaRepository<AcademicEducationEntity, Long> {
    List<AcademicEducationEntity> findAllByUser_Id(UUID userId);
}

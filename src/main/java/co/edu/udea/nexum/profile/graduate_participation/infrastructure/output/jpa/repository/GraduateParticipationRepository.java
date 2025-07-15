package co.edu.udea.nexum.profile.graduate_participation.infrastructure.output.jpa.repository;

import co.edu.udea.nexum.profile.graduate_participation.infrastructure.output.jpa.entity.GraduateParticipationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GraduateParticipationRepository extends JpaRepository<GraduateParticipationEntity, Long> {
    List<GraduateParticipationEntity> findAllByUser_Id(UUID userId);

    List<GraduateParticipationEntity> findAllByUser_IdOrderByCreationDateDesc(UUID userId);
}

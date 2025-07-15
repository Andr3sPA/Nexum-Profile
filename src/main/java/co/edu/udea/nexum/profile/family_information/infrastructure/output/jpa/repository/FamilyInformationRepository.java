package co.edu.udea.nexum.profile.family_information.infrastructure.output.jpa.repository;

import co.edu.udea.nexum.profile.family_information.infrastructure.output.jpa.entity.FamilyInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FamilyInformationRepository extends JpaRepository<FamilyInformationEntity, Long> {
    Optional<FamilyInformationEntity> findTopByUser_IdOrderByCreationDateDesc(UUID userId);
}

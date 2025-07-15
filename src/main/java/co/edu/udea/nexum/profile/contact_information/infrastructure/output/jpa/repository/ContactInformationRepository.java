package co.edu.udea.nexum.profile.contact_information.infrastructure.output.jpa.repository;

import co.edu.udea.nexum.profile.contact_information.infrastructure.output.jpa.entity.ContactInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ContactInformationRepository extends JpaRepository<ContactInformationEntity, Long> {

    Optional<ContactInformationEntity> findTopByUser_IdOrderByCreationDateDesc(UUID userId);

    Optional<ContactInformationEntity> findFirstByUser_IdOrderByCreationDateAsc(UUID userId);
}

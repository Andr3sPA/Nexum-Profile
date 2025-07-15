package co.edu.udea.nexum.profile.innovation_process.infrastructure.output.jpa.repository;

import co.edu.udea.nexum.profile.innovation_process.infrastructure.output.jpa.entity.InnovationProcessEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InnovationProcessRepository extends JpaRepository<InnovationProcessEntity, Long> {
    List<InnovationProcessEntity> findAllByUser_Id(UUID userId);
}

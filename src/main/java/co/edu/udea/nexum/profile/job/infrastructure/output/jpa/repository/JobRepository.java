package co.edu.udea.nexum.profile.job.infrastructure.output.jpa.repository;

import aj.org.objectweb.asm.commons.Remapper;
import co.edu.udea.nexum.profile.job.domain.model.Job;
import co.edu.udea.nexum.profile.job.infrastructure.output.jpa.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, Long> {
    List<JobEntity> findAllByUser_Id(UUID userId);

    Optional<JobEntity> findByUser_IdAndFirstJob(UUID userId, Boolean firstJob);

    Optional<JobEntity> findByUser_IdAndCurrentJob(UUID userId, Boolean currentJob);
}

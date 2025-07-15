package co.edu.udea.nexum.profile.job.infrastructure.output.jpa.adapter;

import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.adapter.impl.BaseCrudAdapterImpl;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import co.edu.udea.nexum.profile.job.domain.model.Job;
import co.edu.udea.nexum.profile.job.domain.spi.JobPersistencePort;
import co.edu.udea.nexum.profile.job.infrastructure.output.jpa.entity.JobEntity;
import co.edu.udea.nexum.profile.job.infrastructure.output.jpa.mapper.JobEntityMapper;
import co.edu.udea.nexum.profile.job.infrastructure.output.jpa.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JobJpaAdapter extends BaseCrudAdapterImpl<Long, Job, JobEntity> implements JobPersistencePort {

    private final JobRepository jobRepository;
    private final JobEntityMapper jobEntityMapper;

    @Override
    protected BaseEntityMapper<Job, JobEntity> getMapper() {
        return jobEntityMapper;
    }

    @Override
    protected CrudRepository<JobEntity, Long> getRepository() {
        return jobRepository;
    }

    @Override
    public List<Job> findByUserId(UUID userId) {
        return jobEntityMapper.toDomains(
                jobRepository.findAllByUser_Id(userId)
        );
    }

    @Override
    public Job findFirstByUserId(UUID id) {
        return jobRepository
                .findByUser_IdAndFirstJob(id, true)
                .map(jobEntityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Job findCurrentByUserId(UUID userId) {
        return jobRepository
                .findByUser_IdAndCurrentJob(userId, true)
                .map(jobEntityMapper::toDomain)
                .orElse(null);
    }
}

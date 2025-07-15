package co.edu.udea.nexum.profile.job.domain.usecase;

import co.edu.udea.nexum.profile.common.domain.exception.EntityAlreadyExistsException;
import co.edu.udea.nexum.profile.common.domain.exception.EntityNotFoundException;
import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.common.domain.usecase.AuditableCrudUseCase;
import co.edu.udea.nexum.profile.job.domain.api.JobServicePort;
import co.edu.udea.nexum.profile.job.domain.model.*;
import co.edu.udea.nexum.profile.job.domain.spi.*;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static co.edu.udea.nexum.profile.common.domain.utils.functions.CommonHelpers.replaceIfNotNull;
import static co.edu.udea.nexum.profile.common.domain.utils.functions.CommonHelpers.validateCatalogReference;
import static co.edu.udea.nexum.profile.job.domain.utils.constants.JobConstants.FIRST_JOB_ALREADY_EXISTS;
import static co.edu.udea.nexum.profile.security.domain.utils.helpers.SecurityHelper.validateCommonUserPermission;

public class JobUseCase extends AuditableCrudUseCase<Long, Job> implements JobServicePort {

    private final JobPersistencePort jobPersistencePort;
    private final UserPersistencePort userPersistencePort;
    private final SalaryRangePersistencePort salaryRangePersistencePort;
    private final JobDelayPersistencePort jobDelayPersistencePort;
    private final JobAreaPersistencePort jobAreaPersistencePort;
    private final JobInstitutionTypePersistencePort institutionTypePersistencePort;

    public JobUseCase(
            JobPersistencePort jobPersistencePort,
            UserPersistencePort userPersistencePort,
            SalaryRangePersistencePort salaryRangePersistencePort,
            JobDelayPersistencePort jobDelayPersistencePort,
            JobAreaPersistencePort jobAreaPersistencePort,
            JobInstitutionTypePersistencePort institutionTypePersistencePort
    ) {
        this.jobPersistencePort = jobPersistencePort;
        this.userPersistencePort = userPersistencePort;
        this.salaryRangePersistencePort = salaryRangePersistencePort;
        this.jobDelayPersistencePort = jobDelayPersistencePort;
        this.jobAreaPersistencePort = jobAreaPersistencePort;
        this.institutionTypePersistencePort = institutionTypePersistencePort;
    }

    @Override
    public Job save(Job model) {
        validateEntity(null, model);
        LocalDateTime now = LocalDateTime.now();
        model.setCreationDate(now);
        model.setLastUpdate(now);

        UUID userId = model.getUser().getId();

        if(model.getFirstJob() && jobPersistencePort.findFirstByUserId(userId) != null)
            throw new EntityAlreadyExistsException(FIRST_JOB_ALREADY_EXISTS);

        if(model.getCurrentJob()) {
            Job currentJob = jobPersistencePort.findCurrentByUserId(userId);
            if(currentJob != null) {
                currentJob.setCurrentJob(false);
                jobPersistencePort.update(currentJob);
            }
        }

        Job enrichedModel = loadAssociations(model);
        return jobPersistencePort.save(enrichedModel);
    }

    @Override
    protected BaseCrudPersistencePort<Long, Job> getPersistencePort() {
        return jobPersistencePort;
    }

    @Override
    protected String getModelClassName() {
        return Job.class.getSimpleName();
    }

    @Override
    protected Job patch(Job original, Job patch) {
        replaceIfNotNull(patch.getCompanyName(), original::setCompanyName);
        replaceIfNotNull(patch.getCountry(), original::setCountry);
        replaceIfNotNull(patch.getPosition(), original::setPosition);
        replaceIfNotNull(patch.getRelatedToProgram(), original::setRelatedToProgram);
        replaceIfNotNull(patch.getSalaryRange(), original::setSalaryRange);
        replaceIfNotNull(patch.getJobDelay(), original::setJobDelay);
        replaceIfNotNull(patch.getJobArea(), original::setJobArea);
        replaceIfNotNull(patch.getInstitutionType(), original::setInstitutionType);
        replaceIfNotNull(patch.getFirstJob(), original::setFirstJob);
        replaceIfNotNull(patch.getUser(), original::setUser);
        return original;
    }

    @Override
    protected void validateEntity(Long currentId, Job model) {
        UUID userId = model.getUser().getId();
        validateCommonUserPermission(userId);
        if (!userPersistencePort.existsById(userId)) throw new EntityNotFoundException(User.class.getSimpleName());
        validateCatalogReference(model.getSalaryRange(), salaryRangePersistencePort::findById, SalaryRange.class);
        validateCatalogReference(model.getJobDelay(), jobDelayPersistencePort::findById, JobDelay.class);
        validateCatalogReference(model.getJobArea(), jobAreaPersistencePort::findById, JobArea.class);
        validateCatalogReference(model.getInstitutionType(), institutionTypePersistencePort::findById, JobInstitutionType.class);
    }

    @Override
    public List<Job> findByUserId(UUID userId) {
        Job firstJob = searchJobData(jobPersistencePort.findFirstByUserId(userId));
        Job currentJob = searchJobData(jobPersistencePort.findCurrentByUserId(userId));

        List<Job> jobs = new ArrayList<>();
        if (firstJob != null) jobs.add(firstJob);
        if (currentJob != null) jobs.add(currentJob);
        return jobs;
    }

    private Job searchJobData(Job job){
        if(job == null) return null;
        JobDelay jobDelay = jobDelayPersistencePort.findById(job.getJobDelay().getId());
        SalaryRange salaryRange = salaryRangePersistencePort.findById(job.getSalaryRange().getId());
        JobArea jobArea = jobAreaPersistencePort.findById(job.getJobArea().getId());
        JobInstitutionType institutionType = institutionTypePersistencePort.findById(job.getInstitutionType().getId());

        job.setJobDelay(jobDelay);
        job.setSalaryRange(salaryRange);
        job.setJobArea(jobArea);
        job.setInstitutionType(institutionType);
        return job;
    }
}

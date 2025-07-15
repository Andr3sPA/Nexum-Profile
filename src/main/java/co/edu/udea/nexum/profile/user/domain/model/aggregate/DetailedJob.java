package co.edu.udea.nexum.profile.user.domain.model.aggregate;

import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;
import co.edu.udea.nexum.profile.job.domain.model.JobArea;
import co.edu.udea.nexum.profile.job.domain.model.JobDelay;
import co.edu.udea.nexum.profile.job.domain.model.JobInstitutionType;
import co.edu.udea.nexum.profile.job.domain.model.SalaryRange;

import java.time.LocalDateTime;

@Generated
public class DetailedJob implements Model<Long> {

    private Long id;
    private String companyName;
    private String country;
    private String position;
    private Boolean relatedToProgram;
    private SalaryRange salaryRange;
    private JobDelay jobDelay;
    private JobArea jobArea;
    private JobInstitutionType institutionType;
    private Boolean firstJob;
    private Boolean currentJob;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;

    @Generated
    private DetailedJob(DetailedJobBuilder builder) {
        this.id = builder.id;
        this.companyName = builder.companyName;
        this.country = builder.country;
        this.position = builder.position;
        this.relatedToProgram = builder.relatedToProgram;
        this.salaryRange = builder.salaryRange;
        this.jobDelay = builder.jobDelay;
        this.jobArea = builder.jobArea;
        this.institutionType = builder.institutionType;
        this.firstJob = builder.firstJob;
        this.currentJob = builder.currentJob;
        this.creationDate = builder.creationDate;
        this.lastUpdate = builder.lastUpdate;
    }

    public static DetailedJobBuilder builder() {
        return new DetailedJobBuilder();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean getRelatedToProgram() {
        return relatedToProgram;
    }

    public void setRelatedToProgram(Boolean relatedToProgram) {
        this.relatedToProgram = relatedToProgram;
    }

    public SalaryRange getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(SalaryRange salaryRange) {
        this.salaryRange = salaryRange;
    }

    public JobDelay getJobDelay() {
        return jobDelay;
    }

    public void setJobDelay(JobDelay jobDelay) {
        this.jobDelay = jobDelay;
    }

    public JobArea getJobArea() {
        return jobArea;
    }

    public void setJobArea(JobArea jobArea) {
        this.jobArea = jobArea;
    }

    public JobInstitutionType getInstitutionType() {
        return institutionType;
    }

    public void setInstitutionType(JobInstitutionType institutionType) {
        this.institutionType = institutionType;
    }

    public Boolean getFirstJob() {
        return firstJob;
    }

    public void setFirstJob(Boolean firstJob) {
        this.firstJob = firstJob;
    }

    public Boolean getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(Boolean currentJob) {
        this.currentJob = currentJob;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    // Builder class

    public static class DetailedJobBuilder implements BaseBuilder<DetailedJob> {
        private Long id;
        private String companyName;
        private String country;
        private String position;
        private Boolean relatedToProgram;
        private SalaryRange salaryRange;
        private JobDelay jobDelay;
        private JobArea jobArea;
        private JobInstitutionType institutionType;
        private Boolean firstJob;
        private Boolean currentJob;
        private LocalDateTime creationDate;
        private LocalDateTime lastUpdate;

        public DetailedJobBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DetailedJobBuilder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public DetailedJobBuilder country(String country) {
            this.country = country;
            return this;
        }

        public DetailedJobBuilder position(String position) {
            this.position = position;
            return this;
        }

        public DetailedJobBuilder relatedToProgram(Boolean relatedToProgram) {
            this.relatedToProgram = relatedToProgram;
            return this;
        }

        public DetailedJobBuilder salaryRange(SalaryRange salaryRange) {
            this.salaryRange = salaryRange;
            return this;
        }

        public DetailedJobBuilder jobDelay(JobDelay jobDelay) {
            this.jobDelay = jobDelay;
            return this;
        }

        public DetailedJobBuilder jobArea(JobArea jobArea) {
            this.jobArea = jobArea;
            return this;
        }

        public DetailedJobBuilder institutionType(JobInstitutionType institutionType) {
            this.institutionType = institutionType;
            return this;
        }

        public DetailedJobBuilder firstJob(Boolean firstJob) {
            this.firstJob = firstJob;
            return this;
        }

        public DetailedJobBuilder currentJob(Boolean currentJob) {
            this.currentJob = currentJob;
            return this;
        }

        public DetailedJobBuilder creationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public DetailedJobBuilder lastUpdate(LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        @Override
        public DetailedJob build() {
            return new DetailedJob(this);
        }
    }
}

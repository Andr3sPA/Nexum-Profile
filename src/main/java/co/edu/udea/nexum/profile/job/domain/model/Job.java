package co.edu.udea.nexum.profile.job.domain.model;

import co.edu.udea.nexum.profile.common.domain.model.AuditableModel;
import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;
import co.edu.udea.nexum.profile.user.domain.model.User;

import java.time.LocalDateTime;

@Generated
public class Job implements Model<Long>, AuditableModel {

    private Long id;
    private User user;
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

    public Job(JobBuilder builder) {
        this.id = builder.id;
        this.user = builder.user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


    public static JobBuilder builder() {
        return new JobBuilder();
    }

    @Generated
    public static class JobBuilder implements BaseBuilder<Job> {
        public User user;
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

        public JobBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public JobBuilder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public JobBuilder country(String country) {
            this.country = country;
            return this;
        }

        public JobBuilder position(String position) {
            this.position = position;
            return this;
        }

        public JobBuilder relatedToProgram(Boolean relatedToProgram) {
            this.relatedToProgram = relatedToProgram;
            return this;
        }

        public JobBuilder salaryRange(SalaryRange salaryRange) {
            this.salaryRange = salaryRange;
            return this;
        }

        public JobBuilder jobDelay(JobDelay jobDelay) {
            this.jobDelay = jobDelay;
            return this;
        }

        public JobBuilder jobArea(JobArea jobArea) {
            this.jobArea = jobArea;
            return this;
        }

        public JobBuilder institutionType(JobInstitutionType institutionType) {
            this.institutionType = institutionType;
            return this;
        }

        public JobBuilder firstJob(Boolean firstJob) {
            this.firstJob = firstJob;
            return this;
        }

        public JobBuilder currentJob(Boolean currentJob) {
            this.currentJob = currentJob;
            return this;
        }

        public JobBuilder creationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public JobBuilder lastUpdate(LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        public JobBuilder user(User user) {
            this.user = user;
            return this;
        }

        @Override
        public Job build() {
            return new Job(this);
        }
    }
}

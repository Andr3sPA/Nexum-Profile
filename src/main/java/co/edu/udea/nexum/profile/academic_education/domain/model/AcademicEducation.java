package co.edu.udea.nexum.profile.academic_education.domain.model;

import co.edu.udea.nexum.profile.academic_education.domain.utils.enums.StudyType;
import co.edu.udea.nexum.profile.common.domain.model.AuditableModel;
import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;
import co.edu.udea.nexum.profile.user.domain.model.User;

import java.time.LocalDateTime;

@Generated
public class AcademicEducation implements Model<Long>, AuditableModel {
    private Long id;
    private User user;
    private StudyType type;
    private String studyName;
    private String institution;
    private String country;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;

    public AcademicEducation(AcademicEducationBuilder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.type = builder.type;
        this.studyName = builder.studyName;
        this.institution = builder.institution;
        this.country = builder.country;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StudyType getType() {
        return type;
    }

    public void setType(StudyType type) {
        this.type = type;
    }

    public String getStudyName() {
        return studyName;
    }

    public void setStudyName(String studyName) {
        this.studyName = studyName;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public static AcademicEducationBuilder builder() {
        return new AcademicEducationBuilder();
    }

    public static class AcademicEducationBuilder implements BaseBuilder<AcademicEducation> {
        private Long id;
        private User user;
        private StudyType type;
        private String studyName;
        private String institution;
        private String country;
        private LocalDateTime creationDate;
        private LocalDateTime lastUpdate;

        public AcademicEducationBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public AcademicEducationBuilder user(User user) {
            this.user = user;
            return this;
        }

        public AcademicEducationBuilder type(StudyType type) {
            this.type = type;
            return this;
        }

        public AcademicEducationBuilder studyName(String studyName) {
            this.studyName = studyName;
            return this;
        }

        public AcademicEducationBuilder institution(String institution) {
            this.institution = institution;
            return this;
        }

        public AcademicEducationBuilder country(String country) {
            this.country = country;
            return this;
        }

        public AcademicEducationBuilder creationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public AcademicEducationBuilder lastUpdate(LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        @Override
        public AcademicEducation build() {
            return new AcademicEducation(this);
        }
    }
}

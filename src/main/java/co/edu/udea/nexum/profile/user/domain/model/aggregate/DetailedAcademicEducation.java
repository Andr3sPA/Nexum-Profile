package co.edu.udea.nexum.profile.user.domain.model.aggregate;

import co.edu.udea.nexum.profile.academic_education.domain.utils.enums.StudyType;
import co.edu.udea.nexum.profile.common.domain.model.Model;

import java.time.LocalDateTime;


import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;

@Generated
public class DetailedAcademicEducation implements Model<Long> {

    private Long id;
    private StudyType type;
    private String studyName;
    private String institution;
    private String country;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;

    @Generated
    private DetailedAcademicEducation(DetailedAcademicEducationBuilder builder) {
        this.id = builder.id;
        this.type = builder.type;
        this.studyName = builder.studyName;
        this.institution = builder.institution;
        this.country = builder.country;
        this.creationDate = builder.creationDate;
        this.lastUpdate = builder.lastUpdate;
    }

    public static DetailedAcademicEducationBuilder builder() {
        return new DetailedAcademicEducationBuilder();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

    public static class DetailedAcademicEducationBuilder implements BaseBuilder<DetailedAcademicEducation> {
        private Long id;
        private StudyType type;
        private String studyName;
        private String institution;
        private String country;
        private LocalDateTime creationDate;
        private LocalDateTime lastUpdate;

        public DetailedAcademicEducationBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DetailedAcademicEducationBuilder type(StudyType type) {
            this.type = type;
            return this;
        }

        public DetailedAcademicEducationBuilder studyName(String studyName) {
            this.studyName = studyName;
            return this;
        }

        public DetailedAcademicEducationBuilder institution(String institution) {
            this.institution = institution;
            return this;
        }

        public DetailedAcademicEducationBuilder country(String country) {
            this.country = country;
            return this;
        }

        public DetailedAcademicEducationBuilder creationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public DetailedAcademicEducationBuilder lastUpdate(LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        @Override
        public DetailedAcademicEducation build() {
            return new DetailedAcademicEducation(this);
        }
    }
}

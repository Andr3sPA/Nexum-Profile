package co.edu.udea.nexum.profile.user.domain.model.filter;

import co.edu.udea.nexum.profile.academic_education.domain.utils.enums.StudyType;
import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;
import co.edu.udea.nexum.profile.user.domain.utils.enums.Gender;

import java.time.LocalDate;
import java.util.List;

@Generated
public class UserFilter {

    private String identityDocument;
    private Long identityDocumentTypeId;
    private String name;
    private String middleName;
    private String lastname;
    private String secondLastname;
    private Gender gender;
    private LocalDate birthdate;

    // Job
    private String companyName;
    private String jobCountry;
    private String position;
    private Boolean relatedToProgram;
    private Long salaryRangeId;
    private Long jobDelayId;
    private Long jobAreaId;
    private Long institutionTypeId;

    // Innovation Process
    private Long innovationTypeId;
    private String innovationName;

    // Coursed Program
    private Integer startYear;
    private Integer endYear;
    private Long programId;

    // Contact
    private String address;
    private String country;
    private String state;
    private String city;
    private String mobile;
    private String email;
    private String academicEmail;
    private Boolean whatsappAuthorization;

    // Auth
    private RoleName role;

    // Academic Education
    private StudyType studyType;
    private String studyName;
    private String academicInstitution;
    private String academicCountry;
    private List<Long> programVersionIds;

    @Generated
    private UserFilter(UserFilterBuilder builder) {
        this.identityDocument = builder.identityDocument;
        this.identityDocumentTypeId = builder.identityDocumentTypeId;
        this.name = builder.name;
        this.middleName = builder.middleName;
        this.lastname = builder.lastname;
        this.secondLastname = builder.secondLastname;
        this.gender = builder.gender;
        this.birthdate = builder.birthdate;

        this.companyName = builder.companyName;
        this.jobCountry = builder.jobCountry;
        this.position = builder.position;
        this.relatedToProgram = builder.relatedToProgram;
        this.salaryRangeId = builder.salaryRangeId;
        this.jobDelayId = builder.jobDelayId;
        this.jobAreaId = builder.jobAreaId;
        this.institutionTypeId = builder.institutionTypeId;

        this.innovationTypeId = builder.innovationTypeId;
        this.innovationName = builder.innovationName;

        this.startYear = builder.startYear;
        this.endYear = builder.endYear;
        this.programId = builder.programId;

        this.address = builder.address;
        this.country = builder.country;
        this.state = builder.state;
        this.city = builder.city;
        this.mobile = builder.mobile;
        this.email = builder.email;
        this.academicEmail = builder.academicEmail;
        this.whatsappAuthorization = builder.whatsappAuthorization;

        this.role = builder.role;

        this.studyType = builder.studyType;
        this.studyName = builder.studyName;
        this.academicInstitution = builder.academicInstitution;
        this.academicCountry = builder.academicCountry;
        this.programVersionIds = builder.programVersionIds;
    }

    public static UserFilterBuilder builder() {
        return new UserFilterBuilder();
    }

    public String getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
    }

    public Long getIdentityDocumentTypeId() {
        return identityDocumentTypeId;
    }

    public void setIdentityDocumentTypeId(Long identityDocumentTypeId) {
        this.identityDocumentTypeId = identityDocumentTypeId;
    }

    public List<Long> getProgramVersionIds() {
        return programVersionIds;
    }

    public void setProgramVersionIds(List<Long> programVersionIds) {
        this.programVersionIds = programVersionIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobCountry() {
        return jobCountry;
    }

    public void setJobCountry(String jobCountry) {
        this.jobCountry = jobCountry;
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

    public Long getSalaryRangeId() {
        return salaryRangeId;
    }

    public void setSalaryRangeId(Long salaryRangeId) {
        this.salaryRangeId = salaryRangeId;
    }

    public Long getJobDelayId() {
        return jobDelayId;
    }

    public void setJobDelayId(Long jobDelayId) {
        this.jobDelayId = jobDelayId;
    }

    public Long getJobAreaId() {
        return jobAreaId;
    }

    public void setJobAreaId(Long jobAreaId) {
        this.jobAreaId = jobAreaId;
    }

    public Long getInstitutionTypeId() {
        return institutionTypeId;
    }

    public void setInstitutionTypeId(Long institutionTypeId) {
        this.institutionTypeId = institutionTypeId;
    }

    public Long getInnovationTypeId() {
        return innovationTypeId;
    }

    public void setInnovationTypeId(Long innovationTypeId) {
        this.innovationTypeId = innovationTypeId;
    }

    public String getInnovationName() {
        return innovationName;
    }

    public void setInnovationName(String innovationName) {
        this.innovationName = innovationName;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAcademicEmail() {
        return academicEmail;
    }

    public void setAcademicEmail(String academicEmail) {
        this.academicEmail = academicEmail;
    }

    public Boolean getWhatsappAuthorization() {
        return whatsappAuthorization;
    }

    public void setWhatsappAuthorization(Boolean whatsappAuthorization) {
        this.whatsappAuthorization = whatsappAuthorization;
    }

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }

    public StudyType getStudyType() {
        return studyType;
    }

    public void setStudyType(StudyType studyType) {
        this.studyType = studyType;
    }

    public String getStudyName() {
        return studyName;
    }

    public void setStudyName(String studyName) {
        this.studyName = studyName;
    }

    public String getAcademicInstitution() {
        return academicInstitution;
    }

    public void setAcademicInstitution(String academicInstitution) {
        this.academicInstitution = academicInstitution;
    }

    public String getAcademicCountry() {
        return academicCountry;
    }

    public void setAcademicCountry(String academicCountry) {
        this.academicCountry = academicCountry;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static class UserFilterBuilder implements BaseBuilder<UserFilter> {
        private String identityDocument;
        private Long identityDocumentTypeId;
        private String name;
        private String middleName;
        private String lastname;
        private String secondLastname;
        private Gender gender;
        private LocalDate birthdate;

        private String companyName;
        private String jobCountry;
        private String position;
        private Boolean relatedToProgram;
        private Long salaryRangeId;
        private Long jobDelayId;
        private Long jobAreaId;
        private Long institutionTypeId;

        private Long innovationTypeId;
        private String innovationName;

        private Integer startYear;
        public Integer endYear;
        private Long programId;
        private List<Long> programVersionIds;

        private String address;
        private String country;
        private String state;
        private String city;
        private String mobile;
        private String email;
        private String academicEmail;
        private Boolean whatsappAuthorization;

        private RoleName role;

        private StudyType studyType;
        private String studyName;
        private String academicInstitution;
        private String academicCountry;

        public UserFilterBuilder identityDocument(String identityDocument) {
            this.identityDocument = identityDocument;
            return this;
        }

        public UserFilterBuilder identityDocumentTypeId(Long identityDocumentTypeId) {
            this.identityDocumentTypeId = identityDocumentTypeId;
            return this;
        }

        public UserFilterBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserFilterBuilder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public UserFilterBuilder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public UserFilterBuilder secondLastname(String secondLastname) {
            this.secondLastname = secondLastname;
            return this;
        }

        public UserFilterBuilder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public UserFilterBuilder birthdate(LocalDate birthdate) {
            this.birthdate = birthdate;
            return this;
        }

        public UserFilterBuilder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public UserFilterBuilder jobCountry(String jobCountry) {
            this.jobCountry = jobCountry;
            return this;
        }

        public UserFilterBuilder programVersionIds(List<Long> programVersionIds) {
            this.programVersionIds = programVersionIds;
            return this;
        }

        public UserFilterBuilder position(String position) {
            this.position = position;
            return this;
        }

        public UserFilterBuilder relatedToProgram(Boolean relatedToProgram) {
            this.relatedToProgram = relatedToProgram;
            return this;
        }

        public UserFilterBuilder salaryRangeId(Long salaryRangeId) {
            this.salaryRangeId = salaryRangeId;
            return this;
        }

        public UserFilterBuilder jobDelayId(Long jobDelayId) {
            this.jobDelayId = jobDelayId;
            return this;
        }

        public UserFilterBuilder jobAreaId(Long jobAreaId) {
            this.jobAreaId = jobAreaId;
            return this;
        }

        public UserFilterBuilder institutionTypeId(Long institutionTypeId) {
            this.institutionTypeId = institutionTypeId;
            return this;
        }

        public UserFilterBuilder innovationTypeId(Long innovationTypeId) {
            this.innovationTypeId = innovationTypeId;
            return this;
        }

        public UserFilterBuilder innovationName(String innovationName) {
            this.innovationName = innovationName;
            return this;
        }

        public UserFilterBuilder startYear(Integer endYear) {
            this.startYear = endYear;
            return this;
        }

        public UserFilterBuilder endYear(Integer endYear) {
            this.endYear = endYear;
            return this;
        }

        public UserFilterBuilder programId(Long programVersionId) {
            this.programId = programVersionId;
            return this;
        }

        public UserFilterBuilder address(String address) {
            this.address = address;
            return this;
        }

        public UserFilterBuilder country(String state) {
            this.country = state;
            return this;
        }

        public UserFilterBuilder city(String city) {
            this.city = city;
            return this;
        }

        public UserFilterBuilder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public UserFilterBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserFilterBuilder academicEmail(String academicEmail) {
            this.academicEmail = academicEmail;
            return this;
        }

        public UserFilterBuilder whatsappAuthorization(Boolean whatsappAuthorization) {
            this.whatsappAuthorization = whatsappAuthorization;
            return this;
        }

        public UserFilterBuilder role(RoleName role) {
            this.role = role;
            return this;
        }

        public UserFilterBuilder studyType(StudyType studyType) {
            this.studyType = studyType;
            return this;
        }

        public UserFilterBuilder studyName(String studyName) {
            this.studyName = studyName;
            return this;
        }

        public UserFilterBuilder academicInstitution(String academicInstitution) {
            this.academicInstitution = academicInstitution;
            return this;
        }

        public UserFilterBuilder academicCountry(String academicCountry) {
            this.academicCountry = academicCountry;
            return this;
        }

        public UserFilterBuilder state(String state) {
            this.state = state;
            return this;
        }

        @Override
        public UserFilter build() {
            return new UserFilter(this);
        }
    }
}

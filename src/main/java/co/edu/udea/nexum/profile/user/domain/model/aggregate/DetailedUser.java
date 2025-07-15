package co.edu.udea.nexum.profile.user.domain.model.aggregate;

import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;
import co.edu.udea.nexum.profile.user.domain.model.IdentityDocumentType;
import co.edu.udea.nexum.profile.user.domain.utils.enums.Gender;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Generated
public class DetailedUser implements Model<UUID> {

    private UUID id;
    private String identityDocument;
    private IdentityDocumentType identityDocumentType;
    private String name;
    private String middleName;
    private String lastname;
    private String secondLastname;
    private String institutionalEmail;
    private Gender gender;
    private LocalDate birthdate;

    private DetailedContactInformation contactInformation;
    private DetailedFamilyInformation familyInformation;
    private DetailedGraduateParticipation graduateParticipation;
    private List<DetailedJob> jobs;
    private List<DetailedCoursedProgram> coursedPrograms;
    private List<DetailedAcademicEducation> academicEducationList;

    private List<DetailedInnovationProcess> innovationProcesses;

    @Generated
    private DetailedUser(DetailedUserBuilder builder) {
        this.id = builder.id;
        this.identityDocument = builder.identityDocument;
        this.identityDocumentType = builder.identityDocumentType;
        this.name = builder.name;
        this.middleName = builder.middleName;
        this.lastname = builder.lastname;
        this.secondLastname = builder.secondLastname;
        this.institutionalEmail = builder.institutionalEmail;
        this.gender = builder.gender;
        this.birthdate = builder.birthdate;
        this.contactInformation = builder.contactInformation;
        this.familyInformation = builder.familyInformation;
        this.graduateParticipation = builder.graduateParticipation;
        this.jobs = builder.jobs;
        this.coursedPrograms = builder.coursedPrograms;
        this.academicEducationList = builder.academicEducationList;
        this.innovationProcesses = builder.innovationProcesses;
    }

    public static DetailedUserBuilder builder() {
        return new DetailedUserBuilder();
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public String getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
    }

    public IdentityDocumentType getIdentityDocumentType() {
        return identityDocumentType;
    }

    public void setIdentityDocumentType(IdentityDocumentType identityDocumentType) {
        this.identityDocumentType = identityDocumentType;
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

    public String getInstitutionalEmail() {
        return institutionalEmail;
    }

    public void setInstitutionalEmail(String institutionalEmail) {
        this.institutionalEmail = institutionalEmail;
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

    public DetailedContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(DetailedContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public DetailedFamilyInformation getFamilyInformation() {
        return familyInformation;
    }

    public void setFamilyInformation(DetailedFamilyInformation familyInformation) {
        this.familyInformation = familyInformation;
    }

    public DetailedGraduateParticipation getGraduateParticipation() {
        return graduateParticipation;
    }

    public void setGraduateParticipation(DetailedGraduateParticipation graduateParticipation) {
        this.graduateParticipation = graduateParticipation;
    }

    public List<DetailedJob> getJobs() {
        return jobs;
    }

    public void setJobs(List<DetailedJob> jobs) {
        this.jobs = jobs;
    }

    public List<DetailedCoursedProgram> getCoursedPrograms() {
        return coursedPrograms;
    }

    public void setCoursedPrograms(List<DetailedCoursedProgram> coursedPrograms) {
        this.coursedPrograms = coursedPrograms;
    }

    public List<DetailedAcademicEducation> getAcademicEducationList() {
        return academicEducationList;
    }

    public void setAcademicEducationList(List<DetailedAcademicEducation> academicEducationList) {
        this.academicEducationList = academicEducationList;
    }

    public List<DetailedInnovationProcess> getInnovationProcesses() {
        return innovationProcesses;
    }

    public void setInnovationProcesses(List<DetailedInnovationProcess> innovationProcesses) {
        this.innovationProcesses = innovationProcesses;
    }

    public static class DetailedUserBuilder implements BaseBuilder<DetailedUser> {
        private UUID id;
        private String identityDocument;
        private IdentityDocumentType identityDocumentType;
        private String name;
        private String middleName;
        private String lastname;
        private String secondLastname;
        private String institutionalEmail;
        private Gender gender;
        private LocalDate birthdate;

        private DetailedContactInformation contactInformation;
        private DetailedFamilyInformation familyInformation;
        private DetailedGraduateParticipation graduateParticipation;
        private List<DetailedJob> jobs;
        private List<DetailedCoursedProgram> coursedPrograms;
        private List<DetailedAcademicEducation> academicEducationList;
        private List<DetailedInnovationProcess> innovationProcesses;

        public DetailedUserBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public DetailedUserBuilder identityDocument(String identityDocument) {
            this.identityDocument = identityDocument;
            return this;
        }

        public DetailedUserBuilder identityDocumentType(IdentityDocumentType identityDocumentType) {
            this.identityDocumentType = identityDocumentType;
            return this;
        }

        public DetailedUserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public DetailedUserBuilder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public DetailedUserBuilder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public DetailedUserBuilder secondLastname(String secondLastname) {
            this.secondLastname = secondLastname;
            return this;
        }

        public DetailedUserBuilder institutionalEmail(String institutionalEmail) {
            this.institutionalEmail = institutionalEmail;
            return this;
        }

        public DetailedUserBuilder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public DetailedUserBuilder birthdate(LocalDate birthdate) {
            this.birthdate = birthdate;
            return this;
        }

        public DetailedUserBuilder contactInformation(DetailedContactInformation contactInformation) {
            this.contactInformation = contactInformation;
            return this;
        }

        public DetailedUserBuilder familyInformation(DetailedFamilyInformation familyInformation) {
            this.familyInformation = familyInformation;
            return this;
        }

        public DetailedUserBuilder graduateParticipation(DetailedGraduateParticipation graduateParticipation) {
            this.graduateParticipation = graduateParticipation;
            return this;
        }

        public DetailedUserBuilder jobs(List<DetailedJob> jobs) {
            this.jobs = jobs;
            return this;
        }

        public DetailedUserBuilder coursedPrograms(List<DetailedCoursedProgram> coursedPrograms) {
            this.coursedPrograms = coursedPrograms;
            return this;
        }

        public DetailedUserBuilder academicEducationList(List<DetailedAcademicEducation> academicEducationList) {
            this.academicEducationList = academicEducationList;
            return this;
        }

        public DetailedUserBuilder innovationProcesses(List<DetailedInnovationProcess> innovationProcesses) {
            this.innovationProcesses = innovationProcesses;
            return this;
        }

        @Override
        public DetailedUser build() {
            return new DetailedUser(this);
        }
    }
}

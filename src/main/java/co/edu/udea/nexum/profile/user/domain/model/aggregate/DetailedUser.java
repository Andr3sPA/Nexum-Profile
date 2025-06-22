package co.edu.udea.nexum.profile.user.domain.model.aggregate;

import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;
import co.edu.udea.nexum.profile.family_information.domain.model.FamilyInformation;
import co.edu.udea.nexum.profile.user.domain.model.IdentityDocumentType;
import co.edu.udea.nexum.profile.user.domain.utils.enums.Gender;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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
    private List<CoursedProgram> coursedPrograms;
    private FamilyInformation familyInformation;
    private LocalDate birthdate;

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

    public List<CoursedProgram> getCoursedPrograms() {
        return coursedPrograms;
    }

    public void setCoursedPrograms(List<CoursedProgram> coursedPrograms) {
        this.coursedPrograms = coursedPrograms;
    }

    public FamilyInformation getFamilyInformation() {
        return familyInformation;
    }

    public void setFamilyInformation(FamilyInformation familyInformation) {
        this.familyInformation = familyInformation;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}

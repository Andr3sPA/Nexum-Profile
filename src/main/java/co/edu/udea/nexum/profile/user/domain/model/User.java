package co.edu.udea.nexum.profile.user.domain.model;

import co.edu.udea.nexum.profile.common.domain.model.AuditableModel;
import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;
import co.edu.udea.nexum.profile.user.domain.utils.enums.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Generated
public class User implements Model<UUID>, AuditableModel {
    private UUID id;
    private String identityDocument;
    private IdentityDocumentType identityDocumentType;
    private String name;
    private String middleName;
    private String lastname;
    private String secondLastname;
    private LocalDate birthdate;
    private Gender gender;
    private String institutionalEmail;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;

    public User(UserBuilder builder) {
        this.id = builder.id;
        this.identityDocument = builder.identityDocument;
        this.identityDocumentType = builder.identityDocumentType;
        this.name = builder.name;
        this.middleName = builder.middleName;
        this.lastname = builder.lastname;
        this.secondLastname = builder.secondLastname;
        this.birthdate = builder.birthdate;
        this.gender = builder.gender;
        this.creationDate = builder.creationDate;
        this.lastUpdate = builder.lastUpdate;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    public String getInstitutionalEmail() {
        return institutionalEmail;
    }

    public void setInstitutionalEmail(String institutionalEmail) {
        this.institutionalEmail = institutionalEmail;
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

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    @Generated
    public static class UserBuilder implements BaseBuilder<User> {
        private UUID id;
        private String identityDocument;
        private IdentityDocumentType identityDocumentType;
        private String name;
        private String middleName;
        private String lastname;
        private String secondLastname;
        private LocalDate birthdate;
        private Gender gender;
        private LocalDateTime creationDate;
        private LocalDateTime lastUpdate;

        public UserBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public UserBuilder identityDocument(String identityDocument) {
            this.identityDocument = identityDocument;
            return this;
        }

        public UserBuilder identityDocumentType(IdentityDocumentType identityDocumentType) {
            this.identityDocumentType = identityDocumentType;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public UserBuilder birthdate(LocalDate birthdate) {
            this.birthdate = birthdate;
            return this;
        }

        public UserBuilder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public UserBuilder secondLastname(String secondLastname) {
            this.secondLastname = secondLastname;
            return this;
        }

        public UserBuilder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public UserBuilder lastUpdate(LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }


        public UserBuilder creationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        @Override
        public User build() {
            return new User(this);
        }
    }
}

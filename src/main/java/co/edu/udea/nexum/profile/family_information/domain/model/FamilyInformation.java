package co.edu.udea.nexum.profile.family_information.domain.model;

import co.edu.udea.nexum.profile.common.domain.model.AuditableModel;
import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;
import co.edu.udea.nexum.profile.family_information.domain.utils.enums.MaritalState;
import co.edu.udea.nexum.profile.user.domain.model.User;

import java.time.LocalDateTime;

@Generated
public class FamilyInformation implements Model<Long>, AuditableModel {
    private Long id;
    private User user;
    private MaritalState maritalState;
    private Short childNumber;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;

    public FamilyInformation(FamiliyInformationBuilder builder) {
       this.id = builder.id;
       this.user = builder.user;
       this.maritalState = builder.maritalState;
       this.childNumber = builder.childNumber;
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

    public MaritalState getMaritalState() {
        return maritalState;
    }

    public void setMaritalState(MaritalState maritalState) {
        this.maritalState = maritalState;
    }

    public Short getChildNumber() {
        return childNumber;
    }

    public void setChildNumber(Short childNumber) {
        this.childNumber = childNumber;
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

    public static final class FamiliyInformationBuilder implements BaseBuilder<FamilyInformation> {
        private Long id;
        private User user;
        private MaritalState maritalState;
        private Short childNumber;
        private LocalDateTime creationDate;
        private LocalDateTime lastUpdate;

        public FamiliyInformationBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public FamiliyInformationBuilder user(User user) {
            this.user = user;
            return this;
        }

        public FamiliyInformationBuilder maritalState(MaritalState maritalState) {
            this.maritalState = maritalState;
            return this;
        }

        public FamiliyInformationBuilder childNumber(Short childNumber) {
            this.childNumber = childNumber;
            return this;
        }

        public FamiliyInformationBuilder creationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public FamiliyInformationBuilder lastUpdate(LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        @Override
        public FamilyInformation build() {
            return new FamilyInformation(this);
        }
    }
}

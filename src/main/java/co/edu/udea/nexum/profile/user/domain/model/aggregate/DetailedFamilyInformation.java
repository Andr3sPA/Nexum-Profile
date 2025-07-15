package co.edu.udea.nexum.profile.user.domain.model.aggregate;

import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;
import co.edu.udea.nexum.profile.family_information.domain.utils.enums.MaritalState;

import java.time.LocalDateTime;

@Generated
public class DetailedFamilyInformation implements Model<Long> {

    private Long id;
    private MaritalState maritalState;
    private Short childNumber;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;

    @Generated
    private DetailedFamilyInformation(DetailedFamilyInformationBuilder builder) {
        this.id = builder.id;
        this.maritalState = builder.maritalState;
        this.childNumber = builder.childNumber;
        this.creationDate = builder.creationDate;
        this.lastUpdate = builder.lastUpdate;
    }

    public static DetailedFamilyInformationBuilder builder() {
        return new DetailedFamilyInformationBuilder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public static class DetailedFamilyInformationBuilder implements BaseBuilder<DetailedFamilyInformation> {
        private Long id;
        private MaritalState maritalState;
        private Short childNumber;
        private LocalDateTime creationDate;
        private LocalDateTime lastUpdate;

        public DetailedFamilyInformationBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DetailedFamilyInformationBuilder maritalState(MaritalState maritalState) {
            this.maritalState = maritalState;
            return this;
        }

        public DetailedFamilyInformationBuilder childNumber(Short childNumber) {
            this.childNumber = childNumber;
            return this;
        }

        public DetailedFamilyInformationBuilder creationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public DetailedFamilyInformationBuilder lastUpdate(LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        @Override
        public DetailedFamilyInformation build() {
            return new DetailedFamilyInformation(this);
        }
    }
}

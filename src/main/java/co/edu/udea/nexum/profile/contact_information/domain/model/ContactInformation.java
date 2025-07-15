package co.edu.udea.nexum.profile.contact_information.domain.model;

import co.edu.udea.nexum.profile.common.domain.model.AuditableModel;
import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;
import co.edu.udea.nexum.profile.user.domain.model.User;

import java.time.LocalDateTime;

@Generated
public class ContactInformation implements Model<Long>, AuditableModel {

    private Long id;
    private User user;
    private String address;
    private String country;
    private String state;
    private String city;
    private String landline;
    private String mobile;
    private String email;
    private String academicEmail;
    private Boolean whatsappAuthorization;
    private Boolean current;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;

    public ContactInformation(ContactInformationBuilder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.address = builder.address;
        this.country = builder.country;
        this.state = builder.state;
        this.city = builder.city;
        this.landline = builder.landline;
        this.mobile = builder.mobile;
        this.email = builder.email;
        this.academicEmail = builder.academicEmail;
        this.whatsappAuthorization = builder.whatsappAuthorization;
        this.current = builder.isCurrent;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
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

    public Boolean getCurrent() {
        return current;
    }

    public void setCurrent(Boolean current) {
        this.current = current;
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

    public static ContactInformationBuilder builder() {
        return new ContactInformationBuilder();
    }

    public static final class ContactInformationBuilder implements BaseBuilder<ContactInformation> {
        private Long id;
        private User user;
        private String address;
        private String country;
        private String state;
        private String city;
        private String landline;
        private String mobile;
        private String email;
        private String academicEmail;
        private Boolean whatsappAuthorization;
        private Boolean isCurrent;
        private LocalDateTime creationDate;
        private LocalDateTime lastUpdate;

        public ContactInformationBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ContactInformationBuilder user(User user) {
            this.user = user;
            return this;
        }

        public ContactInformationBuilder address(String address) {
            this.address = address;
            return this;
        }

        public ContactInformationBuilder country(String country) {
            this.country = country;
            return this;
        }

        public ContactInformationBuilder state(String state) {
            this.state = state;
            return this;
        }

        public ContactInformationBuilder city(String city) {
            this.city = city;
            return this;
        }

        public ContactInformationBuilder landline(String landlinePhone) {
            this.landline = landlinePhone;
            return this;
        }

        public ContactInformationBuilder mobile(String mobilePhone) {
            this.mobile = mobilePhone;
            return this;
        }

        public ContactInformationBuilder email(String personalEmail) {
            this.email = personalEmail;
            return this;
        }

        public ContactInformationBuilder academicEmail(String academicEmail) {
            this.academicEmail = academicEmail;
            return this;
        }

        public ContactInformationBuilder whatsappAuthorization(Boolean whatsappGroupAuthorized) {
            this.whatsappAuthorization = whatsappGroupAuthorized;
            return this;
        }

        public ContactInformationBuilder current(Boolean isCurrent) {
            this.isCurrent = isCurrent;
            return this;
        }

        public ContactInformationBuilder creationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public ContactInformationBuilder lastUpdate(LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        @Override
        public ContactInformation build() {
            return new ContactInformation(this);
        }
    }
}

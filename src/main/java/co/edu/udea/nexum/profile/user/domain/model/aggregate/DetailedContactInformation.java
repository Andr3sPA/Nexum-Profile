package co.edu.udea.nexum.profile.user.domain.model.aggregate;

import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;

@Generated
public class DetailedContactInformation implements Model<Long> {
    private Long id;
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

    @Generated
    private DetailedContactInformation(DetailedContactInformationBuilder builder) {
        this.id = builder.id;
        this.address = builder.address;
        this.country = builder.country;
        this.state = builder.state;
        this.city = builder.city;
        this.landline = builder.landline;
        this.mobile = builder.mobile;
        this.email = builder.email;
        this.academicEmail = builder.academicEmail;
        this.whatsappAuthorization = builder.whatsappAuthorization;
        this.current = builder.current;
    }

    public static DetailedContactInformationBuilder builder() {
        return new DetailedContactInformationBuilder();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

    public void setWhatsappAuthorization(boolean whatsappAuthorization) {
        this.whatsappAuthorization = whatsappAuthorization;
    }

    public boolean getCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public static class DetailedContactInformationBuilder implements BaseBuilder<DetailedContactInformation> {
        private Long id;
        private String address;
        private String country;
        private String state;
        private String city;
        private String landline;
        private String mobile;
        private String email;
        private String academicEmail;
        private boolean whatsappAuthorization;
        private boolean current;

        public DetailedContactInformationBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DetailedContactInformationBuilder address(String address) {
            this.address = address;
            return this;
        }

        public DetailedContactInformationBuilder country(String country) {
            this.country = country;
            return this;
        }

        public DetailedContactInformationBuilder state(String state) {
            this.state = state;
            return this;
        }

        public DetailedContactInformationBuilder city(String city) {
            this.city = city;
            return this;
        }

        public DetailedContactInformationBuilder landline(String landline) {
            this.landline = landline;
            return this;
        }

        public DetailedContactInformationBuilder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public DetailedContactInformationBuilder email(String email) {
            this.email = email;
            return this;
        }

        public DetailedContactInformationBuilder academicEmail(String academicEmail) {
            this.academicEmail = academicEmail;
            return this;
        }

        public DetailedContactInformationBuilder whatsappAuthorization(Boolean whatsappAuthorization) {
            this.whatsappAuthorization = whatsappAuthorization;
            return this;
        }

        public DetailedContactInformationBuilder current(boolean isCurrent) {
            this.current = isCurrent;
            return this;
        }

        @Override
        public DetailedContactInformation build() {
            return new DetailedContactInformation(this);
        }
    }
}

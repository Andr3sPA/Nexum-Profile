package co.edu.udea.nexum.profile.auth.domain.model;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;

import java.util.UUID;


public class AuthorizationData {
    private UUID id;
    private String password;

    @Generated
    public AuthorizationData(AuthorizationDataBuilder builder) {
        this.id = builder.id;
        this.password = builder.password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static AuthorizationDataBuilder builder() {
        return new AuthorizationDataBuilder();
    }

    public static class AuthorizationDataBuilder implements BaseBuilder<AuthorizationData> {
        private UUID id;
        private String password;

        public AuthorizationDataBuilder id(UUID email) {
            this.id = email;
            return this;
        }

        public AuthorizationDataBuilder password(String password) {
            this.password = password;
            return this;
        }

        @Override
        public AuthorizationData build() {
            return new AuthorizationData(this);

        }
    }
}

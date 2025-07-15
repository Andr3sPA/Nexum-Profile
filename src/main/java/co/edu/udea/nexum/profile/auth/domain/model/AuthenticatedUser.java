package co.edu.udea.nexum.profile.auth.domain.model;

import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;

import java.util.UUID;

@Generated
public class AuthenticatedUser {
    private UUID id;
    private String email;
    private RoleName role;
    private String token;

    @Generated
    public AuthenticatedUser(AuthenticatedUserBuilder builder) {
        this.id = builder.id;
        this.role = builder.role;
        this.token = builder.token;
        this.email = builder.email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static AuthenticatedUserBuilder builder(){
        return new AuthenticatedUserBuilder();
    }

    public static class AuthenticatedUserBuilder implements BaseBuilder<AuthenticatedUser> {
        private String email;
        private UUID id;
        private RoleName role;
        private String token;

        public AuthenticatedUserBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public AuthenticatedUserBuilder role(RoleName role) {
            this.role = role;
            return this;
        }

        public AuthenticatedUserBuilder token(String token) {
            this.token = token;
            return this;
        }

        public AuthenticatedUserBuilder email(String email) {
            this.email = email;
            return this;
        }

        @Override
        public AuthenticatedUser build() {
            return new AuthenticatedUser(this);
        }
    }
}

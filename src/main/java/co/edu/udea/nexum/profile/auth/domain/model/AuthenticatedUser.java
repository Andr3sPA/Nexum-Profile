package co.edu.udea.nexum.profile.auth.domain.model;

import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Generated
@Getter
@Setter
public class AuthenticatedUser {
    private UUID id;
    private String email;
    private RoleName role;
    private String token;
    private UUID userId;

    @Generated
    public AuthenticatedUser(AuthenticatedUserBuilder builder) {
        this.id = builder.id;
        this.role = builder.role;
        this.token = builder.token;
        this.email = builder.email;
        this.userId = builder.userId;
    }

    public static AuthenticatedUserBuilder builder(){
        return new AuthenticatedUserBuilder();
    }

    public static class AuthenticatedUserBuilder implements BaseBuilder<AuthenticatedUser> {
        private String email;
        private UUID id;
        private RoleName role;
        private String token;
        private UUID userId;

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

        public AuthenticatedUserBuilder userId(UUID userId) {
            this.userId = userId;
            return this;
        }

        @Override
        public AuthenticatedUser build() {
            return new AuthenticatedUser(this);
        }
    }
}

package co.edu.udea.nexum.profile.auth.domain.model;

import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;
import co.edu.udea.nexum.profile.user.domain.model.User;

import java.time.LocalDateTime;
import java.util.UUID;

@Generated
public class Auth implements Model<UUID> {
    private UUID id;
    private User user;
    private Role role;
    private String email;
    private String password;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;

    @Generated
    public Auth(AuthBuilder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.role = builder.role;
        this.email = builder.email;
        this.password = builder.password;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public static AuthBuilder builder() {
        return new AuthBuilder();
    }

    public static class AuthBuilder implements BaseBuilder<Auth> {
        private UUID id;
        private User user;
        private Role role;
        private String email;
        private String password;
        private LocalDateTime creationDate;
        private LocalDateTime lastUpdate;

        public AuthBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public AuthBuilder user(User user) {
            this.user = user;
            return this;
        }

        public AuthBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public AuthBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AuthBuilder password(String password) {
            this.password = password;
            return this;
        }

        public AuthBuilder creationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public AuthBuilder lastUpdate(LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        @Override
        public Auth build() {
            return new Auth(this);
        }
    }
}

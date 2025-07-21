package co.edu.udea.nexum.profile.auth.domain.model.filter;

import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;

public class AuthFilter {
    private String email;
    private RoleName role;

    public AuthFilter(AuthFilterBuilder builder) {
        this.email = builder.email;
        this.role = builder.role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }

    public static AuthFilterBuilder builder(){
        return new AuthFilterBuilder();
    }

    public static class AuthFilterBuilder {
        private String email;
        private RoleName role;

        public AuthFilterBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AuthFilterBuilder role(RoleName role) {
            this.role = role;
            return this;
        }

        public AuthFilter build(){
            return new AuthFilter(this);
        }
    }
}
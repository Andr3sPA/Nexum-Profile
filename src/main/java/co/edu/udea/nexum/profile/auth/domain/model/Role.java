package co.edu.udea.nexum.profile.auth.domain.model;

import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;

@Generated
public class Role implements Model<Long> {
    private Long id;
    private RoleName name;

    public Role(RoleBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }


    public static RoleBuilder builder(){
        return new RoleBuilder();
    }

    @Generated
    public static class RoleBuilder implements BaseBuilder<Role> {
        private Long id;
        private RoleName name;

        public RoleBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public RoleBuilder name(RoleName name) {
            this.name = name;
            return this;
        }

        @Override
        public Role build() {
            return new Role(this);
        }
    }
}

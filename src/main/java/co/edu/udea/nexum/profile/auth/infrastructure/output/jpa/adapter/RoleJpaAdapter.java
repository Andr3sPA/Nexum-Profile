package co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.adapter;

import co.edu.udea.nexum.profile.auth.domain.model.Role;
import co.edu.udea.nexum.profile.auth.domain.spi.persistence.RolePersistencePort;
import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.entity.RoleEntity;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.mapper.RoleEntityMapper;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.repository.RoleRepository;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.adapter.impl.BaseCrudAdapterImpl;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleJpaAdapter extends BaseCrudAdapterImpl<Long, Role, RoleEntity> implements RolePersistencePort {
    private final RoleRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Override
    public Role findByName(RoleName name) {
        return roleEntityMapper.toDomain(
                roleRepository.findByName(name)
        );
    }

    @Override
    protected BaseEntityMapper<Role, RoleEntity> getMapper() {
        return roleEntityMapper;
    }

    @Override
    protected CrudRepository<RoleEntity, Long> getRepository() {
        return roleRepository;
    }
}

package co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.adapter;

import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.domain.spi.persistence.AuthPersistencePort;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.entity.AuthEntity;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.mapper.AuthEntityMapper;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.repository.AuthRepository;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.adapter.impl.BaseCrudAdapterImpl;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AuthJpaAdapter extends BaseCrudAdapterImpl<UUID, Auth, AuthEntity> implements AuthPersistencePort {
    private final AuthRepository authRepository;
    private final AuthEntityMapper authEntityMapper;

    @Override
    public Auth findByEmail(String email) {
        return authEntityMapper.toDomain(
                authRepository.findByEmail(email)
        );
    }

    @Override
    protected BaseEntityMapper<Auth, AuthEntity> getMapper() {
        return authEntityMapper;
    }

    @Override
    protected CrudRepository<AuthEntity, UUID> getRepository() {
        return authRepository;
    }
}

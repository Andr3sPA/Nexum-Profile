package co.edu.udea.nexum.profile.user.infrastructure.output.jpa.adapter;

import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.adapter.impl.BaseCrudAdapterImpl;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.entity.UserEntity;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.mapper.UserEntityMapper;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserJpaAdapter extends BaseCrudAdapterImpl<UUID, User, UserEntity> implements UserPersistencePort {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    protected BaseEntityMapper<User, UserEntity> getMapper() {
        return userEntityMapper;
    }

    @Override
    protected CrudRepository<UserEntity, UUID> getRepository() {
        return userRepository;
    }

    @Override
    public User findByIdentityDocument(String identityDocument) {
        return userEntityMapper.toDomain(
                userRepository.findByIdentityDocument(identityDocument)
        );
    }

    @Override
    public boolean existsById(UUID id) {
        return userRepository.existsById(id);
    }

    @Override
    public boolean existsByIdentityDocument(String identityDocument) {
        return userRepository.existsByIdentityDocument(identityDocument);
    }
}

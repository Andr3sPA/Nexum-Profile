package co.edu.udea.nexum.profile.user.infrastructure.output.jpa.adapter;

import co.edu.udea.nexum.profile.common.domain.utils.pagination.DomainPage;
import co.edu.udea.nexum.profile.common.domain.utils.pagination.PaginationData;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.adapter.impl.BaseCrudAdapterImpl;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.PaginationDataMapper;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.model.filter.UserFilter;
import co.edu.udea.nexum.profile.user.domain.model.full.FullUser;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.entity.FullUserEntity;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.entity.UserEntity;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.mapper.UserEntityMapper;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.repository.FullUserRepository;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.repository.UserRepository;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.specification.UserSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserJpaAdapter extends BaseCrudAdapterImpl<UUID, User, UserEntity> implements UserPersistencePort {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final FullUserRepository fullUserRepository;
    private final PaginationDataMapper paginationDataMapper;

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
    public DomainPage<FullUser> findAllFiltered(UserFilter filter, PaginationData paginationData) {
        Pageable pageable = paginationDataMapper.toJPA(paginationData).createPageable();
        Specification<FullUserEntity> userSpecification = UserSpec.filterBy(filter);
        return userEntityMapper.toDomainPage(
                fullUserRepository.findAll(userSpecification, pageable)
        );
    }

    @Override
    public List<FullUser> findAllFilteredForReport(UserFilter filterRequest) {
        Specification<FullUserEntity> userSpecification = UserSpec.filterBy(filterRequest);
        return userEntityMapper.toFullDomain(
                fullUserRepository.findAll(userSpecification)
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

    @Override
    public FullUser findFullById(UUID id) {
        return userEntityMapper.toFullDomain(
                fullUserRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"))
        );
    }
}

package co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.adapter;

import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.domain.model.filter.AuthFilter;
import co.edu.udea.nexum.profile.auth.domain.spi.persistence.AuthPersistencePort;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.entity.AuthEntity;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.mapper.AuthEntityMapper;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.repository.AuthRepository;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.specification.AuthSpec;
import co.edu.udea.nexum.profile.common.domain.utils.pagination.DomainPage;
import co.edu.udea.nexum.profile.common.domain.utils.pagination.PaginationData;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.adapter.impl.BaseCrudAdapterImpl;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.PaginationDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AuthJpaAdapter extends BaseCrudAdapterImpl<UUID, Auth, AuthEntity> implements AuthPersistencePort {
    private final AuthRepository authRepository;
    private final AuthEntityMapper authEntityMapper;
    private final PaginationDataMapper paginationDataMapper;

    @Override
    public Auth findByEmail(String email) {
        return authRepository.findByEmail(email)
                .map(authEntityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Auth findByUserId(UUID id) {
        return authRepository.findByUser_Id(id)
                .map(authEntityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public DomainPage<Auth> findAll(AuthFilter filter, PaginationData paginationData) {
        Pageable pageable = paginationDataMapper.toJPA(paginationData).createPageable();

        Specification<AuthEntity> spec = AuthSpec.filterBy(filter);
        Page<AuthEntity> resultPage = authRepository.findAll(spec, pageable);
        return authEntityMapper.toDomainPage(resultPage);
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

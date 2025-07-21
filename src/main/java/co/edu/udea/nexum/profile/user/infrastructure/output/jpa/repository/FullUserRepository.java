package co.edu.udea.nexum.profile.user.infrastructure.output.jpa.repository;

import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.entity.FullUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FullUserRepository extends JpaRepository<FullUserEntity, UUID> {
    Page<FullUserEntity> findAll(Specification<FullUserEntity> specification, Pageable pageable);
    List<FullUserEntity> findAll(Specification<FullUserEntity> specification);
}

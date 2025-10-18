package co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.repository;

import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.entity.AuthEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthRepository extends JpaRepository<AuthEntity, UUID> {
    Optional<AuthEntity> findByEmail(String email);

    Optional<AuthEntity> findByUser_Id(UUID userId);

    Optional<AuthEntity> findByVerificationToken(String token);

    Page<AuthEntity> findAll(Specification<AuthEntity> spec, Pageable pageable);
}

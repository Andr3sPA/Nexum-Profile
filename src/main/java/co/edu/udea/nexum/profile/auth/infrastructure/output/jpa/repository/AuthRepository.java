package co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.repository;

import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthRepository extends JpaRepository<AuthEntity, UUID> {
    AuthEntity findByEmail(String email);
}

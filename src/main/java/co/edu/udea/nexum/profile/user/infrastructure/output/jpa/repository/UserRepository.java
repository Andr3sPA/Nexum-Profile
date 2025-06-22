package co.edu.udea.nexum.profile.user.infrastructure.output.jpa.repository;

import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    boolean existsByIdentityDocument(String identityDocumentId);
    UserEntity findByIdentityDocument(String identityDocument);
}

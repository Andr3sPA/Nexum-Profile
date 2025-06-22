package co.edu.udea.nexum.profile.user.domain.spi;

import co.edu.udea.nexum.profile.user.domain.model.IdentityDocumentType;

public interface IdentityDocumentTypePersistencePort {
    IdentityDocumentType findById(Long id);
}

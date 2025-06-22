package co.edu.udea.nexum.profile.user.infrastructure.output.feign.adapter;

import co.edu.udea.nexum.profile.user.domain.model.IdentityDocumentType;
import co.edu.udea.nexum.profile.user.domain.spi.IdentityDocumentTypePersistencePort;
import co.edu.udea.nexum.profile.user.infrastructure.output.feign.client.IdentityDocumentTypeFeign;
import co.edu.udea.nexum.profile.user.infrastructure.output.feign.mapper.response.IdentityDocumentTypeResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IdentityDocumentTypeFeignAdapter implements IdentityDocumentTypePersistencePort {
    private final IdentityDocumentTypeFeign identityDocumentTypeFeign;
    private final IdentityDocumentTypeResponseMapper identityDocumentTypeResponseMapper;

    @Override
    public IdentityDocumentType findById(Long id) {
        return identityDocumentTypeResponseMapper.toDomain(
                identityDocumentTypeFeign.getIdentityTypeById(id)
        );
    }
}

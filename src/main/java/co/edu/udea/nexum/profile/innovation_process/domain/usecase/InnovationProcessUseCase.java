package co.edu.udea.nexum.profile.innovation_process.domain.usecase;

import co.edu.udea.nexum.profile.common.domain.exception.EntityNotFoundException;
import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.common.domain.usecase.AuditableCrudUseCase;
import co.edu.udea.nexum.profile.innovation_process.domain.api.InnovationProcessServicePort;
import co.edu.udea.nexum.profile.innovation_process.domain.model.InnovationProcess;
import co.edu.udea.nexum.profile.innovation_process.domain.spi.InnovationProcessPersistencePort;
import co.edu.udea.nexum.profile.innovation_process.domain.model.InnovationProcessType;
import co.edu.udea.nexum.profile.innovation_process.domain.spi.InnovationProcessTypePersistencePort;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;

import java.util.List;
import java.util.UUID;

import static co.edu.udea.nexum.profile.common.domain.utils.functions.CommonHelpers.replaceIfNotNull;
import static co.edu.udea.nexum.profile.common.domain.utils.functions.CommonHelpers.validateCatalogReference;
import static co.edu.udea.nexum.profile.security.domain.utils.helpers.SecurityHelper.validateCommonUserPermission;

public class InnovationProcessUseCase extends AuditableCrudUseCase<Long, InnovationProcess>
        implements InnovationProcessServicePort {

    private final InnovationProcessPersistencePort persistencePort;
    private final UserPersistencePort userPersistencePort;
    private final InnovationProcessTypePersistencePort typePersistencePort;

    public InnovationProcessUseCase(
            InnovationProcessPersistencePort persistencePort,
            UserPersistencePort userPersistencePort,
            InnovationProcessTypePersistencePort typePersistencePort
    ) {
        this.persistencePort = persistencePort;
        this.userPersistencePort = userPersistencePort;
        this.typePersistencePort = typePersistencePort;
    }

    @Override
    protected BaseCrudPersistencePort<Long, InnovationProcess> getPersistencePort() {
        return persistencePort;
    }

    @Override
    protected String getModelClassName() {
        return InnovationProcess.class.getSimpleName();
    }

    @Override
    protected InnovationProcess patch(InnovationProcess original, InnovationProcess patch) {
        replaceIfNotNull(patch.getUser(), original::setUser);
        replaceIfNotNull(patch.getType(), original::setType);
        replaceIfNotNull(patch.getName(), original::setName);
        replaceIfNotNull(patch.getDescription(), original::setDescription);
        replaceIfNotNull(patch.getLink(), original::setLink);
        return original;
    }

    @Override
    public InnovationProcess findById(Long id) {
        InnovationProcess innovationProcess = super.findById(id);
        return enrich(innovationProcess);
    }

    @Override
    protected void validateEntity(Long currentId, InnovationProcess model) {
        UUID userId = model.getUser().getId();
        validateCommonUserPermission(userId);
        if (!userPersistencePort.existsById(userId))
            throw new EntityNotFoundException(User.class.getSimpleName());
        validateCatalogReference(model.getType(), typePersistencePort::findById, InnovationProcessType.class);
    }

    private InnovationProcess enrich(InnovationProcess model) {
        model.setType(
                typePersistencePort.findById(model.getType().getId())
        );
        return model;
    }

    @Override
    public List<InnovationProcess> findByUserId(UUID userId) {
        return persistencePort.findByUserId(userId);
    }
}

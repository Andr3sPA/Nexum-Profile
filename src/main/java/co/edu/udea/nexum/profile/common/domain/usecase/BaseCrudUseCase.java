package co.edu.udea.nexum.profile.common.domain.usecase;

import co.edu.udea.nexum.profile.common.domain.api.BaseCrudServicePort;
import co.edu.udea.nexum.profile.common.domain.exception.EntityNotFoundException;
import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;

import java.util.List;

public abstract class BaseCrudUseCase<ID, MODEL extends Model<ID>> implements BaseCrudServicePort<ID, MODEL> {
    @Override
    public MODEL save(MODEL model) {
        validateEntity(null, model);
        return getPersistencePort().save(model);
    }

    @Override
    public List<MODEL> findAll() {
        return getPersistencePort().findAll();
    }

    @Override
    public MODEL findById(ID id) {
        MODEL domainModel = getPersistencePort().findById(id);
        if (domainModel == null)
            throw new EntityNotFoundException(getModelClassName());
        return domainModel;
    }

    @Override
    public MODEL updateById(ID id, MODEL model) {
        findById(id);
        validateEntity(id, model);
        model.setId(id);
        return getPersistencePort().update(model);
    }

    @Override
    public MODEL deleteById(ID id) {
        MODEL domainModel = findById(id);
        getPersistencePort().deleteById(id);
        return domainModel;
    }

    protected abstract BaseCrudPersistencePort<ID, MODEL> getPersistencePort();
    protected abstract String getModelClassName();
    protected abstract void validateEntity(ID currentId, MODEL model);
}

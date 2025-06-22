package co.edu.udea.nexum.profile.common.domain.utils.functions;

import co.edu.udea.nexum.profile.common.domain.model.AuditableModel;
import co.edu.udea.nexum.profile.common.domain.model.Model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.Function;

public class CommonHelpers {

    public static <ID, MODEL extends Model<ID> & AuditableModel> MODEL updateOrCreateNewIfOutdated(
            ID id,
            MODEL newModel,
            MODEL existingModel,
            Duration outdatedThreshold,
            Function<MODEL, MODEL> saveFunction,
            Function<MODEL, MODEL> updateFunction
    ) {
        LocalDateTime now = LocalDateTime.now();
        boolean isOutdated = existingModel.getCreationDate().isBefore(now.minus(outdatedThreshold));

        if (isOutdated) {
            newModel.setId(null);
            newModel.setCreationDate(now);
        } else {
            newModel.setId(id);
            newModel.setCreationDate(existingModel.getCreationDate());
        }

        newModel.setLastUpdate(now);
        return isOutdated ? saveFunction.apply(newModel) : updateFunction.apply(newModel);
    }

}

package co.edu.udea.nexum.profile.family_information.application.handler;

import co.edu.udea.nexum.profile.common.application.handler.BaseCrudHandler;
import co.edu.udea.nexum.profile.family_information.application.dto.request.FamilyInformationRequest;
import co.edu.udea.nexum.profile.family_information.application.dto.response.FamilyInformationResponse;

public interface FamilyInformationHandler extends BaseCrudHandler<Long, FamilyInformationResponse, FamilyInformationRequest> {
}

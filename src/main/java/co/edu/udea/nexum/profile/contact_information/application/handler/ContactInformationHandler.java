package co.edu.udea.nexum.profile.contact_information.application.handler;

import co.edu.udea.nexum.profile.common.application.handler.BaseCrudHandler;
import co.edu.udea.nexum.profile.contact_information.application.dto.request.ContactInformationRequest;
import co.edu.udea.nexum.profile.contact_information.application.dto.response.ContactInformationResponse;

import java.util.UUID;

public interface ContactInformationHandler extends BaseCrudHandler<Long, ContactInformationResponse, ContactInformationRequest> {
    ContactInformationResponse findCurrentByUserId(UUID userId);
}

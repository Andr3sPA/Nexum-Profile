package co.edu.udea.nexum.profile.contact_information.application.handler.impl;

import co.edu.udea.nexum.profile.common.application.handler.impl.BaseCrudHandlerImpl;
import co.edu.udea.nexum.profile.common.application.mapper.BaseRequestMapper;
import co.edu.udea.nexum.profile.common.application.mapper.BaseResponseMapper;
import co.edu.udea.nexum.profile.common.domain.api.BaseCrudServicePort;
import co.edu.udea.nexum.profile.contact_information.application.dto.request.ContactInformationRequest;
import co.edu.udea.nexum.profile.contact_information.application.dto.response.ContactInformationResponse;
import co.edu.udea.nexum.profile.contact_information.application.handler.ContactInformationHandler;
import co.edu.udea.nexum.profile.contact_information.application.mapper.request.ContactInformationRequestMapper;
import co.edu.udea.nexum.profile.contact_information.application.mapper.response.ContactInformationResponseMapper;
import co.edu.udea.nexum.profile.contact_information.domain.api.ContactInformationServicePort;
import co.edu.udea.nexum.profile.contact_information.domain.model.ContactInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContactInformationHandlerImpl
        extends BaseCrudHandlerImpl<Long, ContactInformation, ContactInformationResponse, ContactInformationRequest>
        implements ContactInformationHandler {

    private final ContactInformationServicePort contactInformationServicePort;
    private final ContactInformationResponseMapper contactInformationResponseMapper;
    private final ContactInformationRequestMapper contactInformationRequestMapper;

    @Override
    protected BaseCrudServicePort<Long, ContactInformation> getServicePort() {
        return contactInformationServicePort;
    }

    @Override
    protected BaseResponseMapper<ContactInformation, ContactInformationResponse> getResponseMapper() {
        return contactInformationResponseMapper;
    }

    @Override
    protected BaseRequestMapper<ContactInformation, ContactInformationRequest> getRequestMapper() {
        return contactInformationRequestMapper;
    }

    @Override
    public ContactInformationResponse findCurrentByUserId(UUID userId) {
        ContactInformation current = contactInformationServicePort.findCurrentByUserId(userId);
        return contactInformationResponseMapper.toResponse(current);
    }
}

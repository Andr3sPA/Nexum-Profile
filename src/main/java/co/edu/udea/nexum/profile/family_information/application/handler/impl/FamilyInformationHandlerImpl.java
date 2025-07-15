package co.edu.udea.nexum.profile.family_information.application.handler.impl;

import co.edu.udea.nexum.profile.common.application.handler.impl.BaseCrudHandlerImpl;
import co.edu.udea.nexum.profile.common.application.mapper.BaseRequestMapper;
import co.edu.udea.nexum.profile.common.application.mapper.BaseResponseMapper;
import co.edu.udea.nexum.profile.common.domain.api.BaseCrudServicePort;
import co.edu.udea.nexum.profile.family_information.application.dto.request.FamilyInformationRequest;
import co.edu.udea.nexum.profile.family_information.application.dto.response.FamilyInformationResponse;
import co.edu.udea.nexum.profile.family_information.application.handler.FamilyInformationHandler;
import co.edu.udea.nexum.profile.family_information.application.mapper.request.FamilyInformationRequestMapper;
import co.edu.udea.nexum.profile.family_information.application.mapper.response.FamilyInformationResponseMapper;
import co.edu.udea.nexum.profile.family_information.domain.api.FamilyInformationServicePort;
import co.edu.udea.nexum.profile.family_information.domain.model.FamilyInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FamilyInformationHandlerImpl
        extends BaseCrudHandlerImpl<Long, FamilyInformation, FamilyInformationResponse, FamilyInformationRequest>
        implements FamilyInformationHandler {

    private final FamilyInformationServicePort familyInformationServicePort;
    private final FamilyInformationResponseMapper familyInformationResponseMapper;
    private final FamilyInformationRequestMapper familyInformationRequestMapper;

    @Override
    protected BaseCrudServicePort<Long, FamilyInformation> getServicePort() {
        return familyInformationServicePort;
    }

    @Override
    protected BaseResponseMapper<FamilyInformation, FamilyInformationResponse> getResponseMapper() {
        return familyInformationResponseMapper;
    }

    @Override
    protected BaseRequestMapper<FamilyInformation, FamilyInformationRequest> getRequestMapper() {
        return familyInformationRequestMapper;
    }
}

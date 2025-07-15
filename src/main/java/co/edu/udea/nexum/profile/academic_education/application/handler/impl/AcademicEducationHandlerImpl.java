package co.edu.udea.nexum.profile.academic_education.application.handler.impl;

import co.edu.udea.nexum.profile.academic_education.application.dto.request.AcademicEducationRequest;
import co.edu.udea.nexum.profile.academic_education.application.dto.response.AcademicEducationResponse;
import co.edu.udea.nexum.profile.academic_education.application.handler.AcademicEducationHandler;
import co.edu.udea.nexum.profile.academic_education.application.mapper.request.AcademicEducationRequestMapper;
import co.edu.udea.nexum.profile.academic_education.application.mapper.response.AcademicEducationResponseMapper;
import co.edu.udea.nexum.profile.academic_education.domain.api.AcademicEducationServicePort;
import co.edu.udea.nexum.profile.academic_education.domain.model.AcademicEducation;
import co.edu.udea.nexum.profile.common.application.handler.impl.BaseCrudHandlerImpl;
import co.edu.udea.nexum.profile.common.application.mapper.BaseRequestMapper;
import co.edu.udea.nexum.profile.common.application.mapper.BaseResponseMapper;
import co.edu.udea.nexum.profile.common.domain.api.BaseCrudServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AcademicEducationHandlerImpl
        extends BaseCrudHandlerImpl<Long, AcademicEducation, AcademicEducationResponse, AcademicEducationRequest>
        implements AcademicEducationHandler {

    private final AcademicEducationServicePort academicEducationServicePort;
    private final AcademicEducationRequestMapper academicEducationRequestMapper;
    private final AcademicEducationResponseMapper academicEducationResponseMapper;

    @Override
    protected BaseCrudServicePort<Long, AcademicEducation> getServicePort() {
        return academicEducationServicePort;
    }

    @Override
    protected BaseRequestMapper<AcademicEducation, AcademicEducationRequest> getRequestMapper() {
        return academicEducationRequestMapper;
    }

    @Override
    protected BaseResponseMapper<AcademicEducation, AcademicEducationResponse> getResponseMapper() {
        return academicEducationResponseMapper;
    }
}

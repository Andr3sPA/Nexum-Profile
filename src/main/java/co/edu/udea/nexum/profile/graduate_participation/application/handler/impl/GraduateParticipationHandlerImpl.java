package co.edu.udea.nexum.profile.graduate_participation.application.handler.impl;

import co.edu.udea.nexum.profile.common.application.handler.impl.BaseCrudHandlerImpl;
import co.edu.udea.nexum.profile.common.application.mapper.BaseRequestMapper;
import co.edu.udea.nexum.profile.common.application.mapper.BaseResponseMapper;
import co.edu.udea.nexum.profile.common.domain.api.BaseCrudServicePort;
import co.edu.udea.nexum.profile.graduate_participation.application.dto.request.GraduateParticipationRequest;
import co.edu.udea.nexum.profile.graduate_participation.application.dto.response.GraduateParticipationResponse;
import co.edu.udea.nexum.profile.graduate_participation.application.handler.GraduateParticipationHandler;
import co.edu.udea.nexum.profile.graduate_participation.application.mapper.request.GraduateParticipationRequestMapper;
import co.edu.udea.nexum.profile.graduate_participation.application.mapper.response.GraduateParticipationResponseMapper;
import co.edu.udea.nexum.profile.graduate_participation.domain.api.GraduateParticipationServicePort;
import co.edu.udea.nexum.profile.graduate_participation.domain.model.GraduateParticipation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GraduateParticipationHandlerImpl
        extends BaseCrudHandlerImpl<Long, GraduateParticipation, GraduateParticipationResponse, GraduateParticipationRequest>
        implements GraduateParticipationHandler {

    private final GraduateParticipationServicePort servicePort;
    private final GraduateParticipationResponseMapper responseMapper;
    private final GraduateParticipationRequestMapper requestMapper;

    @Override
    protected BaseCrudServicePort<Long, GraduateParticipation> getServicePort() {
        return servicePort;
    }

    @Override
    protected BaseResponseMapper<GraduateParticipation, GraduateParticipationResponse> getResponseMapper() {
        return responseMapper;
    }

    @Override
    protected BaseRequestMapper<GraduateParticipation, GraduateParticipationRequest> getRequestMapper() {
        return requestMapper;
    }

    @Override
    public List<GraduateParticipationResponse> findByUserId(UUID userId) {
        return responseMapper.toResponses(
                servicePort.findByUserId(userId)
        );
    }
}

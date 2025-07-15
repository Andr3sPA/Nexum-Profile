package co.edu.udea.nexum.profile.graduate_participation.application.handler;

import co.edu.udea.nexum.profile.common.application.handler.BaseCrudHandler;
import co.edu.udea.nexum.profile.graduate_participation.application.dto.request.GraduateParticipationRequest;
import co.edu.udea.nexum.profile.graduate_participation.application.dto.response.GraduateParticipationResponse;

import java.util.List;
import java.util.UUID;

public interface GraduateParticipationHandler extends BaseCrudHandler<Long, GraduateParticipationResponse, GraduateParticipationRequest> {
    List<GraduateParticipationResponse> findByUserId(UUID userId);
}

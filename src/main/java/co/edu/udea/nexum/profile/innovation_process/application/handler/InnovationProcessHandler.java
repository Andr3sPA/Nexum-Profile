package co.edu.udea.nexum.profile.innovation_process.application.handler;

import co.edu.udea.nexum.profile.common.application.handler.BaseCrudHandler;
import co.edu.udea.nexum.profile.innovation_process.application.dto.request.InnovationProcessRequest;
import co.edu.udea.nexum.profile.innovation_process.application.dto.response.InnovationProcessResponse;

import java.util.List;
import java.util.UUID;

public interface InnovationProcessHandler extends BaseCrudHandler<Long, InnovationProcessResponse, InnovationProcessRequest> {
    List<InnovationProcessResponse> findByUserId(UUID userId);
}

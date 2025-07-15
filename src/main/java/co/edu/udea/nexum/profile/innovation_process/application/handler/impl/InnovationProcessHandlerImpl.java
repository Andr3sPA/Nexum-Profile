package co.edu.udea.nexum.profile.innovation_process.application.handler.impl;

import co.edu.udea.nexum.profile.common.application.handler.impl.BaseCrudHandlerImpl;
import co.edu.udea.nexum.profile.common.application.mapper.BaseRequestMapper;
import co.edu.udea.nexum.profile.common.application.mapper.BaseResponseMapper;
import co.edu.udea.nexum.profile.common.domain.api.BaseCrudServicePort;
import co.edu.udea.nexum.profile.innovation_process.application.dto.request.InnovationProcessRequest;
import co.edu.udea.nexum.profile.innovation_process.application.dto.response.InnovationProcessResponse;
import co.edu.udea.nexum.profile.innovation_process.application.handler.InnovationProcessHandler;
import co.edu.udea.nexum.profile.innovation_process.application.mapper.request.InnovationProcessRequestMapper;
import co.edu.udea.nexum.profile.innovation_process.application.mapper.response.InnovationProcessResponseMapper;
import co.edu.udea.nexum.profile.innovation_process.domain.api.InnovationProcessServicePort;
import co.edu.udea.nexum.profile.innovation_process.domain.model.InnovationProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InnovationProcessHandlerImpl
        extends BaseCrudHandlerImpl<Long, InnovationProcess, InnovationProcessResponse, InnovationProcessRequest>
        implements InnovationProcessHandler {

    private final InnovationProcessServicePort servicePort;
    private final InnovationProcessResponseMapper responseMapper;
    private final InnovationProcessRequestMapper requestMapper;

    @Override
    protected BaseCrudServicePort<Long, InnovationProcess> getServicePort() {
        return servicePort;
    }

    @Override
    protected BaseResponseMapper<InnovationProcess, InnovationProcessResponse> getResponseMapper() {
        return responseMapper;
    }

    @Override
    protected BaseRequestMapper<InnovationProcess, InnovationProcessRequest> getRequestMapper() {
        return requestMapper;
    }

    @Override
    public List<InnovationProcessResponse> findByUserId(UUID userId) {
        return responseMapper.toResponses(
                servicePort.findByUserId(userId)
        );
    }
}

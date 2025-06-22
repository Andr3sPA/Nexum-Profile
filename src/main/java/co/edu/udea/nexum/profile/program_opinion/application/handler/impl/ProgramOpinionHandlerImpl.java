package co.edu.udea.nexum.profile.program_opinion.application.handler.impl;

import co.edu.udea.nexum.profile.common.application.handler.impl.BaseCrudHandlerImpl;
import co.edu.udea.nexum.profile.common.application.mapper.BaseRequestMapper;
import co.edu.udea.nexum.profile.common.application.mapper.BaseResponseMapper;
import co.edu.udea.nexum.profile.common.domain.api.BaseCrudServicePort;
import co.edu.udea.nexum.profile.program_opinion.application.dto.request.ProgramOpinionRequest;
import co.edu.udea.nexum.profile.program_opinion.application.dto.response.ProgramOpinionResponse;
import co.edu.udea.nexum.profile.program_opinion.application.handler.ProgramOpinionHandler;
import co.edu.udea.nexum.profile.program_opinion.application.mapper.request.ProgramOpinionRequestMapper;
import co.edu.udea.nexum.profile.program_opinion.application.mapper.response.ProgramOpinionResponseMapper;
import co.edu.udea.nexum.profile.program_opinion.domain.api.ProgramOpinionServicePort;
import co.edu.udea.nexum.profile.program_opinion.domain.model.ProgramOpinion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgramOpinionHandlerImpl extends BaseCrudHandlerImpl<Long, ProgramOpinion, ProgramOpinionResponse, ProgramOpinionRequest> implements ProgramOpinionHandler {
    private final ProgramOpinionServicePort programOpinionServicePort;
    private final ProgramOpinionResponseMapper programOpinionResponseMapper;
    private final ProgramOpinionRequestMapper programOpinionRequestMapper;

    @Override
    protected BaseCrudServicePort<Long, ProgramOpinion> getServicePort() {
        return programOpinionServicePort;
    }

    @Override
    protected BaseResponseMapper<ProgramOpinion, ProgramOpinionResponse> getResponseMapper() {
        return programOpinionResponseMapper;
    }

    @Override
    protected BaseRequestMapper<ProgramOpinion, ProgramOpinionRequest> getRequestMapper() {
        return programOpinionRequestMapper;
    }
}

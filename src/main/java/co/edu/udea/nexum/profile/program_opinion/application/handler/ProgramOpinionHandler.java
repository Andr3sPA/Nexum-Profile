package co.edu.udea.nexum.profile.program_opinion.application.handler;

import co.edu.udea.nexum.profile.common.application.handler.BaseCrudHandler;
import co.edu.udea.nexum.profile.program_opinion.application.dto.request.ProgramOpinionRequest;
import co.edu.udea.nexum.profile.program_opinion.application.dto.response.ProgramOpinionResponse;

public interface ProgramOpinionHandler
        extends BaseCrudHandler<Long, ProgramOpinionResponse, ProgramOpinionRequest> {
}

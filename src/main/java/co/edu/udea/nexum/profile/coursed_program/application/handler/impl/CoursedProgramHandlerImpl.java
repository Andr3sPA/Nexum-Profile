package co.edu.udea.nexum.profile.coursed_program.application.handler.impl;

import co.edu.udea.nexum.profile.common.application.handler.impl.BaseCrudHandlerImpl;
import co.edu.udea.nexum.profile.common.application.mapper.BaseRequestMapper;
import co.edu.udea.nexum.profile.common.application.mapper.BaseResponseMapper;
import co.edu.udea.nexum.profile.common.domain.api.BaseCrudServicePort;
import co.edu.udea.nexum.profile.coursed_program.application.dto.request.CoursedProgramRequest;
import co.edu.udea.nexum.profile.coursed_program.application.dto.response.CoursedProgramResponse;
import co.edu.udea.nexum.profile.coursed_program.application.handler.CoursedProgramHandler;
import co.edu.udea.nexum.profile.coursed_program.application.mapper.request.CoursedProgramRequestMapper;
import co.edu.udea.nexum.profile.coursed_program.application.mapper.response.CoursedProgramResponseMapper;
import co.edu.udea.nexum.profile.coursed_program.domain.api.CoursedProgramServicePort;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoursedProgramHandlerImpl
        extends BaseCrudHandlerImpl<Long, CoursedProgram, CoursedProgramResponse, CoursedProgramRequest>
        implements CoursedProgramHandler {

    private final CoursedProgramServicePort coursedProgramServicePort;
    private final CoursedProgramResponseMapper coursedProgramResponseMapper;
    private final CoursedProgramRequestMapper coursedProgramRequestMapper;

    @Override
    protected BaseCrudServicePort<Long, CoursedProgram> getServicePort() {
        return coursedProgramServicePort;
    }

    @Override
    protected BaseResponseMapper<CoursedProgram, CoursedProgramResponse> getResponseMapper() {
        return coursedProgramResponseMapper;
    }

    @Override
    protected BaseRequestMapper<CoursedProgram, CoursedProgramRequest> getRequestMapper() {
        return coursedProgramRequestMapper;
    }
}

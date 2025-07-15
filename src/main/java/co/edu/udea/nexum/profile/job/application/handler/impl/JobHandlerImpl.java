package co.edu.udea.nexum.profile.job.application.handler.impl;

import co.edu.udea.nexum.profile.common.application.handler.impl.BaseCrudHandlerImpl;
import co.edu.udea.nexum.profile.common.application.mapper.BaseRequestMapper;
import co.edu.udea.nexum.profile.common.application.mapper.BaseResponseMapper;
import co.edu.udea.nexum.profile.common.domain.api.BaseCrudServicePort;
import co.edu.udea.nexum.profile.job.application.dto.request.JobRequest;
import co.edu.udea.nexum.profile.job.application.dto.response.JobResponse;
import co.edu.udea.nexum.profile.job.application.handler.JobHandler;
import co.edu.udea.nexum.profile.job.application.mapper.request.JobRequestMapper;
import co.edu.udea.nexum.profile.job.application.mapper.response.JobResponseMapper;
import co.edu.udea.nexum.profile.job.domain.api.JobServicePort;
import co.edu.udea.nexum.profile.job.domain.model.Job;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JobHandlerImpl
        extends BaseCrudHandlerImpl<Long, Job, JobResponse, JobRequest>
        implements JobHandler {

    private final JobServicePort jobServicePort;
    private final JobResponseMapper jobResponseMapper;
    private final JobRequestMapper jobRequestMapper;

    @Override
    protected BaseCrudServicePort<Long, Job> getServicePort() {
        return jobServicePort;
    }

    @Override
    protected BaseResponseMapper<Job, JobResponse> getResponseMapper() {
        return jobResponseMapper;
    }

    @Override
    protected BaseRequestMapper<Job, JobRequest> getRequestMapper() {
        return jobRequestMapper;
    }

    @Override
    public List<JobResponse> findByUserId(UUID userId) {
        return jobResponseMapper.toResponses(
                jobServicePort.findByUserId(userId)
        );
    }
}

package co.edu.udea.nexum.profile.job.application.handler;

import co.edu.udea.nexum.profile.common.application.handler.BaseCrudHandler;
import co.edu.udea.nexum.profile.job.application.dto.request.JobRequest;
import co.edu.udea.nexum.profile.job.application.dto.response.JobResponse;

import java.util.List;
import java.util.UUID;

public interface JobHandler extends BaseCrudHandler<Long, JobResponse, JobRequest> {
    List<JobResponse> findByUserId(UUID userId);
}

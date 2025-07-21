package co.edu.udea.nexum.profile.report.application.handler.impl;

import co.edu.udea.nexum.profile.report.application.dto.request.ReportFilterRequest;
import co.edu.udea.nexum.profile.report.application.dto.response.GraduateReportResponse;
import co.edu.udea.nexum.profile.report.application.handler.ReportHandler;
import co.edu.udea.nexum.profile.report.application.mapper.request.ReportRequestMapper;
import co.edu.udea.nexum.profile.report.application.mapper.response.ReportResponseMapper;
import co.edu.udea.nexum.profile.report.domain.api.ReportServicePort;
import co.edu.udea.nexum.profile.report.domain.utils.enums.ReportFormat;
import co.edu.udea.nexum.profile.user.domain.model.filter.UserFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportHandlerImpl implements ReportHandler {
    private final ReportRequestMapper reportRequestMapper;
    private final ReportServicePort reportServicePort;
    private final ReportResponseMapper reportResponseMapper;

    @Override
    public byte[] generateReportFile(ReportFilterRequest filterRequest, ReportFormat format) {
        UserFilter filter = reportRequestMapper.toDomain(filterRequest);
        return reportServicePort.generateGraduateReportFile(filter, format);
    }

    @Override
    public GraduateReportResponse generateReport(ReportFilterRequest filterRequest) {
        UserFilter filter = reportRequestMapper.toDomain(filterRequest);
        return reportResponseMapper.toResponse(
                reportServicePort.generateReport(filter)
        );
    }
}

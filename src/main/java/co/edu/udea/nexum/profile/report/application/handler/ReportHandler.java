package co.edu.udea.nexum.profile.report.application.handler;

import co.edu.udea.nexum.profile.report.application.dto.request.ReportFilterRequest;
import co.edu.udea.nexum.profile.report.application.dto.response.GraduateReportResponse;
import co.edu.udea.nexum.profile.report.domain.utils.enums.ReportFormat;

public interface ReportHandler {
    byte[] generateReportFile(ReportFilterRequest filterRequest, ReportFormat format);
    GraduateReportResponse generateReport(ReportFilterRequest filterRequest);
}

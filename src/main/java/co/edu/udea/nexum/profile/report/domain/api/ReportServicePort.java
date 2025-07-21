package co.edu.udea.nexum.profile.report.domain.api;

import co.edu.udea.nexum.profile.report.domain.model.GraduateReport;
import co.edu.udea.nexum.profile.report.domain.utils.enums.ReportFormat;
import co.edu.udea.nexum.profile.user.domain.model.filter.UserFilter;

public interface ReportServicePort {
    byte[] generateGraduateReportFile(UserFilter filter, ReportFormat format);
    GraduateReport generateReport(UserFilter filter);
}

package co.edu.udea.nexum.profile.report.domain.spi;

import co.edu.udea.nexum.profile.report.domain.ReportFileGenerationException;
import co.edu.udea.nexum.profile.report.domain.model.GraduateReport;
import co.edu.udea.nexum.profile.report.domain.utils.enums.ReportFormat;

public interface ReportGenerationPort {
    public byte[] generateReport(GraduateReport model, ReportFormat format) throws ReportFileGenerationException;
}

package co.edu.udea.nexum.profile.report.infrastructure.output.jasper.adapter;

import co.edu.udea.nexum.profile.report.domain.ReportFileGenerationException;
import co.edu.udea.nexum.profile.report.domain.model.GraduateReport;
import co.edu.udea.nexum.profile.report.domain.spi.ReportGenerationPort;
import co.edu.udea.nexum.profile.report.domain.utils.enums.ReportFormat;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.*;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static co.edu.udea.nexum.profile.report.infrastructure.output.jasper.utils.constants.JasperReportConstants.*;

@Component
public class JasperReportAdapter implements ReportGenerationPort {


    @Override
    public byte[] generateReport(GraduateReport model, ReportFormat format) throws ReportFileGenerationException {
        try {
            InputStream templateStream = getClass().getClassLoader().getResourceAsStream(TEMPLATES_REPORT_GRADUATE_REPORT_JRXML);
            if (templateStream == null) throw new IllegalArgumentException(TEMPLATE_NOT_FOUND + TEMPLATES_REPORT_GRADUATE_REPORT_JRXML);

            JasperReport jasperReport = JasperCompileManager.compileReport(templateStream);

            Map<String, Object> parameters = buildParameters(model);
            JRBeanCollectionDataSource jrDataSource = new JRBeanCollectionDataSource(model.getUsers());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            switch (format) {
                case PDF -> generatePDF(jasperPrint, outputStream);
                case XLSX -> generateXLSX(jasperPrint, outputStream);
                case HTML -> generateHTML(jasperPrint, outputStream);
                default -> throw new UnsupportedOperationException(NOT_SUPPORTED_FORMAT + format);
            }

            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new ReportFileGenerationException(REPORT_GENERATION_ERROR, e);
        }
    }

    private Map<String, Object> buildParameters(GraduateReport model) {
        Map<String, Object> params = new HashMap<>();
        params.put(PROGRAM, model.getProgram());
        params.put(GENDER, model.getGender());
        params.put(COUNTRY, model.getCountry());
        params.put(STATE, model.getState());
        params.put(CITY, model.getCity());

        params.put(TOTAL_GRADUATES, model.getTotalGraduates());
        params.put(WOMAN_COUNT, model.getWomanCount());
        params.put(MAN_COUNT, model.getManCount());
        params.put(NON_BINARY_COUNT, model.getNonBinaryCount());
        params.put(OTHER_COUNT, model.getOtherCount());

        params.put(WOMAN_PERCENTAGE, model.getWomanPercentage());
        params.put(MAN_PERCENTAGE, model.getManPercentage());
        params.put(NON_BINARY_PERCENTAGE, model.getNonBinaryPercentage());
        params.put(OTHER_PERCENTAGE, model.getOtherPercentage());

        params.put(START_YEAR, model.getStartYear());
        params.put(END_YEAR, model.getEndYear());

        InputStream logoStream = getClass().getClassLoader().getResourceAsStream(LOGO_URL);
        if (logoStream == null) throw new ReportFileGenerationException(SEARCHING_LOGO_ERROR);
        params.put(LOGO, logoStream);

        return params;
    }


    private void generateHTML(JasperPrint jasperPrint, ByteArrayOutputStream outputStream) throws JRException {
        HtmlExporter exporter = new HtmlExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleHtmlExporterOutput(outputStream));
        exporter.setConfiguration(new SimpleHtmlReportConfiguration());
        exporter.exportReport();
    }

    private void generateXLSX(JasperPrint jasperPrint, ByteArrayOutputStream outputStream) throws JRException {
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        exporter.setConfiguration(new SimpleXlsxReportConfiguration());
        exporter.exportReport();
    }

    private void generatePDF(JasperPrint jasperPrint, ByteArrayOutputStream outputStream) throws JRException {
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }

}

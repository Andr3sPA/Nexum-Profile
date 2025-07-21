package co.edu.udea.nexum.profile.report.infrastructure.utils.constants;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Generated
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReportRestConstants {

    // Controller path and metadata
    public static final String REPORT_CONTROLLER_PATH = "/v1/reports";
    public static final String REPORT_CONTROLLER_NAME = "Reporte";
    public static final String REPORT_CONTROLLER_DESCRIPTION = "Generación de reportes a partir de filtros complejos";

    // Paths
    public static final String REPORT_GRADUATE_PATH = "/graduates";

    // Swagger metadata
    public static final String SWAGGER_GENERATE_GRADUATE_REPORT_SUMMARY = "Genera el reporte de egresados con los filtros entregados";
    public static final String SWAGGER_GENERATE_GRADUATE_REPORT_SUCCESS = "Reporte generado correctamente";

    // Summary endpoint path
    public static final String REPORT_GRADUATE_SUMMARY_PATH = "/graduates/summary";

    // Swagger summary for summary endpoint
    public static final String SWAGGER_GENERATE_GRADUATE_REPORT_SUMMARY_JSON = "Obtiene el resumen del reporte de egresados con los filtros entregados";
    public static final String SWAGGER_GENERATE_GRADUATE_REPORT_SUCCESS_JSON = "Resumen generado correctamente";


    public static final String FORMAT_STRING = "format";
    public static final String STRING = "string";
    public static final String BINARY_STRING = "binary";
    public static final String PDF_STRING = "PDF";
    public static final String XLSX_FORMAT = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    public static final String HEADERS_TEMPLATE = "attachment; filename=graduate-report";
    public static final String FILE_FORMAT_DOT = ".";
}

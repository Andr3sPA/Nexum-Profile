package co.edu.udea.nexum.profile.report.infrastructure.output.jasper.utils.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JasperReportConstants {
    public static final String TEMPLATES_REPORT_GRADUATE_REPORT_JRXML = "templates/report/graduate-report.jrxml";
    public static final String TEMPLATE_NOT_FOUND = "No se encontró la plantilla: ";
    public static final String NOT_SUPPORTED_FORMAT = "Formato no soportado: ";
    public static final String LOGO_URL = "templates/report/logo_udea_horizontal.png";
    public static final String REPORT_GENERATION_ERROR = "Error generando el reporte";
    public static final String SEARCHING_LOGO_ERROR = "No se pudo cargar el logo desde: templates/report/logo_udea_horizontal.png";
    public static final String LOGO = "logo";
    public static final String END_YEAR = "endYear";
    public static final String START_YEAR = "startYear";
    public static final String OTHER_PERCENTAGE = "otherPercentage";
    public static final String NON_BINARY_PERCENTAGE = "nonBinaryPercentage";
    public static final String MAN_PERCENTAGE = "manPercentage";
    public static final String WOMAN_PERCENTAGE = "womanPercentage";
    public static final String OTHER_COUNT = "otherCount";
    public static final String NON_BINARY_COUNT = "nonBinaryCount";
    public static final String MAN_COUNT = "manCount";
    public static final String WOMAN_COUNT = "womanCount";
    public static final String TOTAL_GRADUATES = "totalGraduates";
    public static final String CITY = "city";
    public static final String STATE = "state";
    public static final String COUNTRY = "country";
    public static final String GENDER = "gender";
    public static final String PROGRAM = "program";
}

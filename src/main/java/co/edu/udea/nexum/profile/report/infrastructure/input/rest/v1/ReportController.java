package co.edu.udea.nexum.profile.report.infrastructure.input.rest.v1;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.report.application.dto.request.ReportFilterRequest;
import co.edu.udea.nexum.profile.report.application.dto.response.GraduateReportResponse;
import co.edu.udea.nexum.profile.report.application.handler.ReportHandler;
import co.edu.udea.nexum.profile.report.domain.utils.enums.ReportFormat;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static co.edu.udea.nexum.profile.common.infrastructure.utils.constants.CommonRestConstants.SWAGGER_CODE_OK;
import static co.edu.udea.nexum.profile.report.infrastructure.utils.constants.ReportRestConstants.*;

@Generated
@RestController
@RequiredArgsConstructor
@RequestMapping(REPORT_CONTROLLER_PATH)
@Tag(name = REPORT_CONTROLLER_NAME, description = REPORT_CONTROLLER_DESCRIPTION)
public class ReportController {
    private final ReportHandler reportHandler;

    @Operation(summary = SWAGGER_GENERATE_GRADUATE_REPORT_SUMMARY)
    @ApiResponse(
            responseCode = SWAGGER_CODE_OK,
            description = SWAGGER_GENERATE_GRADUATE_REPORT_SUCCESS,
            content = @Content(schema = @Schema(type = STRING, format = BINARY_STRING))
    )
    @GetMapping(REPORT_GRADUATE_PATH)
    public ResponseEntity<byte[]> generateGraduateReport(
            ReportFilterRequest filterRequest,
            @RequestParam(name = FORMAT_STRING, defaultValue = PDF_STRING) ReportFormat format
    ) {
        byte[] reportBytes = reportHandler.generateReportFile(filterRequest, format);

        String contentType = switch (format) {
            case PDF -> MediaType.APPLICATION_PDF_VALUE;
            case HTML -> MediaType.TEXT_HTML_VALUE;
            case XLSX -> XLSX_FORMAT;
        };

        LocalDateTime now = LocalDateTime.now();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, HEADERS_TEMPLATE + now + FILE_FORMAT_DOT + format.name().toLowerCase())
                .contentType(MediaType.parseMediaType(contentType))
                .body(reportBytes);
    }

    @Operation(summary = SWAGGER_GENERATE_GRADUATE_REPORT_SUMMARY_JSON)
    @ApiResponse(
            responseCode = SWAGGER_CODE_OK,
            description = SWAGGER_GENERATE_GRADUATE_REPORT_SUCCESS_JSON,
            content = @Content(schema = @Schema(implementation = GraduateReportResponse.class))
    )
    @GetMapping(REPORT_GRADUATE_SUMMARY_PATH)
    public ResponseEntity<GraduateReportResponse> getGraduateReportSummary(
            ReportFilterRequest filterRequest
    ) {
        return ResponseEntity.ok(reportHandler.generateReport(filterRequest));
    }
}

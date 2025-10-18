package co.edu.udea.nexum.profile.report.application.mapper.response;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.report.application.dto.response.GraduateReportResponse;
import co.edu.udea.nexum.profile.report.domain.model.GraduateReport;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReportResponseMapper {
    GraduateReportResponse toResponse(GraduateReport report);
}

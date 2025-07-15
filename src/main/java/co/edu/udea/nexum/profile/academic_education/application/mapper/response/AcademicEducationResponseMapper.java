package co.edu.udea.nexum.profile.academic_education.application.mapper.response;

import co.edu.udea.nexum.profile.academic_education.application.dto.response.AcademicEducationResponse;
import co.edu.udea.nexum.profile.academic_education.domain.model.AcademicEducation;
import co.edu.udea.nexum.profile.common.application.mapper.BaseResponseMapper;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface AcademicEducationResponseMapper extends BaseResponseMapper<AcademicEducation, AcademicEducationResponse> {
}

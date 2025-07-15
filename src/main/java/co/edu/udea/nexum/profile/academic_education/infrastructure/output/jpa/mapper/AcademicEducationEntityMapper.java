package co.edu.udea.nexum.profile.academic_education.infrastructure.output.jpa.mapper;

import co.edu.udea.nexum.profile.academic_education.domain.model.AcademicEducation;
import co.edu.udea.nexum.profile.academic_education.infrastructure.output.jpa.entity.AcademicEducationEntity;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface AcademicEducationEntityMapper extends BaseEntityMapper<AcademicEducation, AcademicEducationEntity> {
}

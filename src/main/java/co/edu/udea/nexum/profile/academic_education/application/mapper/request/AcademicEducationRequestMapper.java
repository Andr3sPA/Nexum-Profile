package co.edu.udea.nexum.profile.academic_education.application.mapper.request;

import co.edu.udea.nexum.profile.academic_education.application.dto.request.AcademicEducationRequest;
import co.edu.udea.nexum.profile.academic_education.domain.model.AcademicEducation;
import co.edu.udea.nexum.profile.common.application.mapper.BaseRequestMapper;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AcademicEducationRequestMapper extends BaseRequestMapper<AcademicEducation, AcademicEducationRequest> {

    default User getUser(UUID userId) {
        return User.builder()
                .id(userId)
                .build();
    }

    @Override
    @Mapping(source = "userId", target = "user")
    AcademicEducation toDomain(AcademicEducationRequest request);
}

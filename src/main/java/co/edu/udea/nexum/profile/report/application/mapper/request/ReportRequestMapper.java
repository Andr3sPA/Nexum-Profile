package co.edu.udea.nexum.profile.report.application.mapper.request;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.report.application.dto.request.ReportFilterRequest;
import co.edu.udea.nexum.profile.user.domain.model.filter.UserFilter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReportRequestMapper {

    UserFilter toDomain(ReportFilterRequest request);
}

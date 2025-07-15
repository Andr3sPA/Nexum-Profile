package co.edu.udea.nexum.profile.family_information.application.mapper.response;

import co.edu.udea.nexum.profile.common.application.mapper.BaseResponseMapper;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.family_information.application.dto.response.FamilyInformationResponse;
import co.edu.udea.nexum.profile.family_information.domain.model.FamilyInformation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface FamilyInformationResponseMapper extends BaseResponseMapper<FamilyInformation, FamilyInformationResponse> {
}

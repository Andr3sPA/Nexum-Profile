package co.edu.udea.nexum.profile.family_information.infrastructure.output.jpa.mapper;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import co.edu.udea.nexum.profile.family_information.domain.model.FamilyInformation;
import co.edu.udea.nexum.profile.family_information.infrastructure.output.jpa.entity.FamilyInformationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface FamilyInformationEntityMapper extends BaseEntityMapper<FamilyInformation, FamilyInformationEntity> {
}

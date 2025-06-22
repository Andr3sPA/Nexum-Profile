package co.edu.udea.nexum.profile.user.infrastructure.output.feign.mapper.response;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.output.feign.mapper.FeignResponseMapper;
import co.edu.udea.nexum.profile.user.domain.model.IdentityDocumentType;
import co.edu.udea.nexum.profile.user.domain.utils.enums.DocumentType;
import co.edu.udea.nexum.profile.user.infrastructure.output.feign.dto.response.IdentityDocumentTypeFeignResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IdentityDocumentTypeResponseMapper extends FeignResponseMapper<IdentityDocumentType, IdentityDocumentTypeFeignResponse> {
    @Override
    default IdentityDocumentType toDomain(IdentityDocumentTypeFeignResponse response){
        return IdentityDocumentType.builder()
                .id(response.getId())
                .documentType(DocumentType.valueOf(response.getAbbreviation()))
                .build();
    }
}

package co.edu.udea.nexum.profile.contact_information.application.mapper.request;

import co.edu.udea.nexum.profile.common.application.mapper.BaseRequestMapper;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.contact_information.application.dto.request.ContactInformationRequest;
import co.edu.udea.nexum.profile.contact_information.domain.model.ContactInformation;
import co.edu.udea.nexum.profile.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContactInformationRequestMapper extends BaseRequestMapper<ContactInformation, ContactInformationRequest> {

    default User getUser(UUID userId) {
        return User.builder()
                .id(userId)
                .build();
    }

    @Override
    @Mapping(source = "userId", target = "user")
    ContactInformation toDomain(ContactInformationRequest request);
}

package co.edu.udea.nexum.profile.user.infrastructure.output.jpa.mapper;

import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import co.edu.udea.nexum.profile.user.domain.model.IdentityDocumentType;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.infrastructure.output.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper extends BaseEntityMapper<User, UserEntity> {
    default Long idIdentDocumentType(IdentityDocumentType identityDocumentType){
        return identityDocumentType.getId();
    }

    default IdentityDocumentType identityDocumentType(Long idIdentDocumentType){
        return IdentityDocumentType.builder()
                .id(idIdentDocumentType)
                .build();
    }

    @Override
    @Mapping(source = "idIdentityDocumentType", target = "identityDocumentType")
    User toDomain(UserEntity userEntity);

    @Override
    @Mapping(source = "identityDocumentType", target = "idIdentityDocumentType")
    UserEntity toEntity(User user);
}

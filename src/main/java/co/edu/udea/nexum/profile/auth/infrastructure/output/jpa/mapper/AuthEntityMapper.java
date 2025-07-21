package co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.mapper;

import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.entity.AuthEntity;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.pagination.DomainPage;
import co.edu.udea.nexum.profile.common.infrastructure.output.jpa.mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthEntityMapper extends BaseEntityMapper<Auth, AuthEntity> {
    @Mapping(target = "page", source = "number")
    @Mapping(target = "pageSize", source = "size")
    @Mapping(target = "totalPages", source = "totalPages")
    @Mapping(target = "count", source = "numberOfElements")
    @Mapping(target = "totalCount", source = "totalElements")
    @Mapping(target = "content", source = "content")
    DomainPage<Auth> toDomainPage(Page<AuthEntity> page);
}

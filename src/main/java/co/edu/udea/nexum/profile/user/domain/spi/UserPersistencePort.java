package co.edu.udea.nexum.profile.user.domain.spi;

import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.common.domain.utils.pagination.DomainPage;
import co.edu.udea.nexum.profile.common.domain.utils.pagination.PaginationData;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.model.filter.UserFilter;
import co.edu.udea.nexum.profile.user.domain.model.full.FullUser;

import java.util.List;
import java.util.UUID;

public interface UserPersistencePort extends BaseCrudPersistencePort<UUID, User> {
    boolean existsById(UUID id);
    boolean existsByIdentityDocument(String identityDocument);
    User findByIdentityDocument(String identityDocument);
    FullUser findFullById(UUID id);
    DomainPage<FullUser> findAllFiltered(UserFilter filter, PaginationData paginationData);
    List<FullUser> findAllFilteredForReport(UserFilter filterRequest);
    
    // Optimized methods for education-employability analysis
    long countGraduates(UserFilter filter);
    long countEmployedGraduates(UserFilter filter);
    List<Object[]> countGraduatesAndEmployedByProgram();
}

package co.edu.udea.nexum.profile.user.domain.usecase;

import co.edu.udea.nexum.profile.auth.domain.model.Auth;
import co.edu.udea.nexum.profile.auth.domain.model.AuthenticatedUser;
import co.edu.udea.nexum.profile.auth.domain.spi.persistence.AuthPersistencePort;
import co.edu.udea.nexum.profile.auth.domain.spi.security.AuthenticationSecurityPort;
import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.common.domain.exception.EntityAlreadyExistsException;
import co.edu.udea.nexum.profile.common.domain.spi.BaseCrudPersistencePort;
import co.edu.udea.nexum.profile.common.domain.usecase.AuditableCrudUseCase;
import co.edu.udea.nexum.profile.common.domain.utils.pagination.DomainPage;
import co.edu.udea.nexum.profile.common.domain.utils.pagination.PaginationData;
import co.edu.udea.nexum.profile.contact_information.domain.model.ContactInformation;
import co.edu.udea.nexum.profile.coursed_program.domain.model.CoursedProgram;
import co.edu.udea.nexum.profile.coursed_program.domain.model.aggregate.FullProgramVersion;
import co.edu.udea.nexum.profile.coursed_program.domain.spi.ProgramVersionPersistencePort;
import co.edu.udea.nexum.profile.job.domain.model.Job;
import co.edu.udea.nexum.profile.user.domain.api.UserServicePort;
import co.edu.udea.nexum.profile.user.domain.model.IdentityDocumentType;
import co.edu.udea.nexum.profile.user.domain.model.User;
import co.edu.udea.nexum.profile.user.domain.model.basic.BasicProgram;
import co.edu.udea.nexum.profile.user.domain.model.basic.BasicUser;
import co.edu.udea.nexum.profile.user.domain.model.filter.UserFilter;
import co.edu.udea.nexum.profile.user.domain.model.full.FullUser;
import co.edu.udea.nexum.profile.user.domain.spi.IdentityDocumentTypePersistencePort;
import co.edu.udea.nexum.profile.user.domain.spi.UserPersistencePort;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static co.edu.udea.nexum.profile.common.domain.utils.functions.CommonHelpers.replaceIfNotNull;
import static co.edu.udea.nexum.profile.user.domain.utils.constants.UserConstants.*;

@Slf4j
public class UserUseCase extends AuditableCrudUseCase<UUID, User> implements UserServicePort {
    private final UserPersistencePort userPersistencePort;
    private final IdentityDocumentTypePersistencePort identityDocumentTypePersistencePort;
    private final AuthenticationSecurityPort authenticationSecurityPort;
    private final ProgramVersionPersistencePort programVersionPersistencePort;
    private final AuthPersistencePort authPersistencePort;

    public UserUseCase(
            UserPersistencePort userPersistencePort,
            IdentityDocumentTypePersistencePort identityDocumentTypePersistencePort,
            AuthenticationSecurityPort authenticationSecurityPort,
            ProgramVersionPersistencePort programVersionPersistencePort,
            AuthPersistencePort authPersistencePort) {
        this.userPersistencePort = userPersistencePort;
        this.identityDocumentTypePersistencePort = identityDocumentTypePersistencePort;
        this.authenticationSecurityPort = authenticationSecurityPort;
        this.programVersionPersistencePort = programVersionPersistencePort;
        this.authPersistencePort = authPersistencePort;
    }

    @Override
    public User findById(UUID uuid) {
        User user = super.findById(uuid);
        IdentityDocumentType type = identityDocumentTypePersistencePort
                .findById(user.getIdentityDocumentType().getId());
        user.setIdentityDocumentType(type);
        return user;
    }

    @Override
    protected BaseCrudPersistencePort<UUID, User> getPersistencePort() {
        return userPersistencePort;
    }

    @Override
    protected String getModelClassName() {
        return User.class.getSimpleName();
    }

    @Override
    protected User loadAssociations(User user) {
        IdentityDocumentType type = identityDocumentTypePersistencePort
                .findById(user.getIdentityDocumentType().getId());
        user.setIdentityDocumentType(type);
        return user;
    }

    @Override
    protected User patch(User original, final User patch) {
        replaceIfNotNull(patch.getIdentityDocument(), original::setIdentityDocument);
        replaceIfNotNull(patch.getIdentityDocumentType(), original::setIdentityDocumentType);
        replaceIfNotNull(patch.getName(), original::setName);
        replaceIfNotNull(patch.getMiddleName(), original::setMiddleName);
        replaceIfNotNull(patch.getLastname(), original::setLastname);
        replaceIfNotNull(patch.getSecondLastname(), original::setSecondLastname);
        replaceIfNotNull(patch.getBirthdate(), original::setBirthdate);
        replaceIfNotNull(patch.getGender(), original::setGender);
        replaceIfNotNull(patch.getInstitutionalEmail(), original::setInstitutionalEmail);
        return original;
    }

    @Override
    protected void validateEntity(UUID currentId, User user) {
        User existingByDocument = userPersistencePort.findByIdentityDocument(user.getIdentityDocument());
        if (existingByDocument != null && !existingByDocument.getId().equals(currentId))
            throw new EntityAlreadyExistsException(getModelClassName(), IDENTITY_DOCUMENT_ATTRIBUTE,
                    user.getIdentityDocument());
    }

    @Override
    public User findAuthenticatedUser() {
        AuthenticatedUser authenticatedUser = authenticationSecurityPort.getAuthenticatedUser();
        Auth auth = authPersistencePort.findById(authenticatedUser.getId());
        return findById(auth.getUser().getId());
    }

    @Override
    public BasicUser findAuthenticatedUserBasic() {
        AuthenticatedUser authenticatedUser = authenticationSecurityPort.getAuthenticatedUser();
        Auth auth = authPersistencePort.findById(authenticatedUser.getId());
        List<FullProgramVersion> programVersions = programVersionPersistencePort.findAll();
        Map<Long, FullProgramVersion> programVersionMap = programVersions.stream()
                .collect(Collectors.toMap(FullProgramVersion::getId, Function.identity()));
        FullUser fullUser = userPersistencePort.findFullById(auth.getUser().getId());
        return parseFull2Basic(fullUser, programVersionMap);
    }

    @Override
    public BasicUser findUserBasicByAuthId(UUID authId) {
        Auth auth = authPersistencePort.findById(authId);
        List<FullProgramVersion> programVersions = programVersionPersistencePort.findAll();
        Map<Long, FullProgramVersion> programVersionMap = programVersions.stream()
                .collect(Collectors.toMap(FullProgramVersion::getId, Function.identity()));
        FullUser fullUser = userPersistencePort.findFullById(auth.getUser().getId());
        return parseFull2Basic(fullUser, programVersionMap);
    }

    @Override
    public DomainPage<BasicUser> findAllFiltered(UserFilter filter, PaginationData paginationData) {
        List<FullProgramVersion> programVersions = programVersionPersistencePort.findAll();
        Map<Long, FullProgramVersion> programVersionMap = programVersions.stream()
                .collect(Collectors.toMap(FullProgramVersion::getId, Function.identity()));
        log.info("ProgramIds: {}", filter.getProgramIds() == null ? "null" : Arrays.toString(filter.getProgramIds()));
        if (filter.getProgramIds() != null && filter.getProgramIds().length > 0) {
            List<FullProgramVersion> objectiveVersions = programVersionPersistencePort.findAll().stream()
                    .filter(version -> Arrays.stream(filter.getProgramIds())
                            .anyMatch(version.getProgram().getId()::equals))
                    .toList();
            filter.setProgramVersionIds(objectiveVersions.stream()
                    .map(FullProgramVersion::getId)
                    .toList());
        }

        DomainPage<FullUser> page = userPersistencePort.findAllFiltered(filter, paginationData);
        List<BasicUser> basicUsers = page.getContent().stream()
                .map(user -> parseFull2Basic(user, programVersionMap))
                .toList();

        return DomainPage.<BasicUser>builder()
                .page(page.getPage())
                .pageSize(page.getPageSize())
                .totalPages(page.getTotalPages())
                .count(page.getCount())
                .totalCount(page.getTotalCount())
                .content(basicUsers)
                .build();
    }

    private BasicUser parseFull2Basic(FullUser user, Map<Long, FullProgramVersion> catalog) {
        ContactInformation current = Optional.ofNullable(user.getContactInformationList())
                .orElseGet(List::of).stream()
                .filter(Objects::nonNull)
                .filter(ContactInformation::getCurrent)
                .max(Comparator.comparing(ContactInformation::getLastUpdate,
                        Comparator.nullsFirst(Comparator.naturalOrder())))
                .orElse(DEFAULT_NULL_CONTACT_INFORMATION);

        RoleName roleName = Optional.ofNullable(user.getAuth())
                .orElse(DEFAULT_NULL_AUTH)
                .getRole()
                .getName();

        Integer graduationYear = Optional.ofNullable(user.getCoursedPrograms())
                .orElseGet(List::of).stream()
                .filter(Objects::nonNull)
                .mapToInt(CoursedProgram::getGraduationYear)
                .max()
                .orElse(0);

        String company = Optional.ofNullable(user.getJobs())
                .orElseGet(List::of).stream()
                .filter(Objects::nonNull)
                .filter(Job::getCurrentJob)
                .findFirst()
                .map(Job::getCompanyName)
                .orElse(null);

        return BasicUser.builder()
                .id(user.getId())
                .name(user.getName())
                .middleName(user.getMiddleName())
                .lastname(user.getLastname())
                .secondLastname(user.getSecondLastname())
                .gender(user.getGender())
                .email(current.getEmail())
                .academicEmail(current.getAcademicEmail())
                .programs(getBasicPrograms(catalog, user.getCoursedPrograms()))
                .mobile(current.getMobile())
                .country(current.getCountry())
                .city(current.getCity())
                .role(roleName)
                .graduationYear(graduationYear)
                .lastUpdateDate(user.getLastUpdate())
                .company(company)
                .build();
    }

    private List<BasicProgram> getBasicPrograms(Map<Long, FullProgramVersion> catalog, List<CoursedProgram> versions) {
        return versions.stream()
                .map(version -> {
                    FullProgramVersion item = catalog.get(version.getProgramVersion().getId());
                    if (item == null || item.getProgram() == null)
                        return null;
                    return BasicProgram.builder()
                            .code(item.getProgram().getCode())
                            .name(item.getProgram().getName())
                            .build();
                })
                .filter(Objects::nonNull)
                .toList();
    }

}

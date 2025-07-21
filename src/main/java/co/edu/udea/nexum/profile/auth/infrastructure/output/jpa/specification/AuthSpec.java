package co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.specification;

import co.edu.udea.nexum.profile.auth.domain.model.filter.AuthFilter;
import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.auth.infrastructure.output.jpa.entity.AuthEntity;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

public class AuthSpec {

    private static final String ROLE = "role";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    public static final String LIKE_SYMBOL = "%";

    private AuthSpec() {}

    public static Specification<AuthEntity> filterBy(AuthFilter filter) {
        return Specification
                .where(hasEmailLike(filter.getEmail()))
                .and(hasRole(filter.getRole()));
    }

    private static Specification<AuthEntity> hasEmailLike(String email) {
        return (root, query, cb) -> email == null || email.isEmpty()
                ? cb.conjunction()
                : cb.like(cb.lower(root.get(EMAIL)), LIKE_SYMBOL + email.toLowerCase() + LIKE_SYMBOL);
    }

    private static Specification<AuthEntity> hasRole(RoleName role) {
        return (root, query, cb) -> role == null
                ? cb.conjunction()
                : cb.equal(root.join(ROLE, JoinType.INNER).get(NAME), role);
    }
}

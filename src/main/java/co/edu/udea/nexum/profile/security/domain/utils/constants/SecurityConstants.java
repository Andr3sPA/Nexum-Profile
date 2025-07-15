package co.edu.udea.nexum.profile.security.domain.utils.constants;

import co.edu.udea.nexum.profile.auth.domain.utils.enums.RoleName;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;

import java.util.List;

@Generated
public class SecurityConstants {


    public static final String UTILITY_CLASS = "Utility class";
    public static final List<RoleName> ALLOWED_ROLES = List.of(RoleName.DEAN, RoleName.ADMINISTRATIVE);
    public static final String HELPER_NOT_PROPERLY_CONFIGURED = "SecurityHelper is not properly configured";

    private SecurityConstants() {
        throw new IllegalStateException(UTILITY_CLASS);
    }
}

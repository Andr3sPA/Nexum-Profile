package co.edu.udea.nexum.profile.auth.domain.exception;

import co.edu.udea.nexum.profile.auth.domain.utils.constants.AuthDomainConstants;
import co.edu.udea.nexum.profile.common.domain.exception.NexumException;

public class BadCredentialsException extends NexumException {

    public BadCredentialsException() {
        super(AuthDomainConstants.BAD_CREDENTIALS_MESSAGE);
    }
}

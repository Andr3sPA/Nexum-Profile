package co.edu.udea.nexum.profile.auth.domain.exception;

import co.edu.udea.nexum.profile.auth.domain.utils.constants.AuthDomainConstants;

public class BadCredentialsException extends RuntimeException{

    public BadCredentialsException() {
        super(AuthDomainConstants.BAD_CREDENTIALS_MESSAGE);
    }
}

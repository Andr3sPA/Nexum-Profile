package co.edu.udea.nexum.profile.auth.domain.spi.security;

import co.edu.udea.nexum.profile.auth.domain.model.AuthenticatedUser;
import co.edu.udea.nexum.profile.common.domain.exception.ExpiredTokenException;
import co.edu.udea.nexum.profile.common.domain.exception.InvalidTokenException;

public interface TokenSecurityPort {
    AuthenticatedUser validateToken(String token) throws InvalidTokenException, ExpiredTokenException;
}

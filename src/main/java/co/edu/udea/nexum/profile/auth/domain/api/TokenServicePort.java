package co.edu.udea.nexum.profile.auth.domain.api;

import co.edu.udea.nexum.profile.auth.domain.model.AuthenticatedUser;
import co.edu.udea.nexum.profile.user.domain.model.User;

public interface TokenServicePort {
    AuthenticatedUser validateToken(String token);
    User getUserByToken(String token);
}

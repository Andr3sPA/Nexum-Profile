package co.edu.udea.nexum.profile.user.domain.api;

import co.edu.udea.nexum.profile.common.domain.api.BaseCrudServicePort;
import co.edu.udea.nexum.profile.user.application.dto.request.UserRequest;
import co.edu.udea.nexum.profile.user.domain.model.User;

import java.util.UUID;

public interface UserServicePort extends BaseCrudServicePort<UUID, User> {
    User findAuthenticatedUser();
}

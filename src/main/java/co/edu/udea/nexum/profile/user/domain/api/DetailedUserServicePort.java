package co.edu.udea.nexum.profile.user.domain.api;

import co.edu.udea.nexum.profile.user.domain.model.aggregate.DetailedUser;

import java.util.UUID;

public interface DetailedUserServicePort {
    DetailedUser findById(UUID id);
    DetailedUser findAuthenticated();
}

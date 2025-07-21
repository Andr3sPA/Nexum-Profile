package co.edu.udea.nexum.profile.user.application.handler;

import co.edu.udea.nexum.profile.user.application.dto.response.detailed.DetailedUserResponse;

import java.util.UUID;

public interface DetailedUserHandler {
    DetailedUserResponse findById(UUID id);
    DetailedUserResponse findAuthenticated();
}

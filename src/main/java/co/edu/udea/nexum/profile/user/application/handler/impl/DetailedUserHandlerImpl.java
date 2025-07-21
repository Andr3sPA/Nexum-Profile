package co.edu.udea.nexum.profile.user.application.handler.impl;

import co.edu.udea.nexum.profile.user.application.dto.response.detailed.DetailedUserResponse;
import co.edu.udea.nexum.profile.user.application.handler.DetailedUserHandler;
import co.edu.udea.nexum.profile.user.application.mapper.response.DetailedUserResponseMapper;
import co.edu.udea.nexum.profile.user.domain.api.DetailedUserServicePort;
import co.edu.udea.nexum.profile.user.domain.model.aggregate.DetailedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DetailedUserHandlerImpl implements DetailedUserHandler {

    private final DetailedUserServicePort detailedUserServicePort;
    private final DetailedUserResponseMapper detailedUserResponseMapper;

    @Override
    public DetailedUserResponse findById(UUID id) {
        DetailedUser detailedUser = detailedUserServicePort.findById(id);
        return detailedUserResponseMapper.toResponse(detailedUser);
    }

    @Override
    public DetailedUserResponse findAuthenticated() {
        return detailedUserResponseMapper.toResponse(
                detailedUserServicePort.findAuthenticated()
        );
    }
}

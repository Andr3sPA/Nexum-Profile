package co.edu.udea.nexum.profile.auth.infrastructure.output.feign.adapter;

import co.edu.udea.nexum.profile.auth.infrastructure.output.feign.client.OpportunityFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OpportunityFeignAdapter {

    private final OpportunityFeign opportunityFeign;

    public void assignOwnerByEditCode(String editCode, String ownerId) {
        opportunityFeign.assignOwnerByEditCode(editCode, ownerId);
    }
}

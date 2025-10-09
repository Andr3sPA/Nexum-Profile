package co.edu.udea.nexum.profile.auth.infrastructure.output.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "nexum-opportunity", url = "${nexum.opportunity.base-url:http://localhost:8120/nexum}")
public interface OpportunityFeign {

  @PutMapping("/v1/opportunities/assign-owner/{editCode}")
  void assignOwnerByEditCode(@PathVariable String editCode, @RequestBody String ownerId);
}

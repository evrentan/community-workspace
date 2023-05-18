package evrentan.community.eventmanager.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(value = "community-manager")
public interface CommunityService {

    @GetMapping(value = "/community/checkCommunityStatus/{id}", consumes = "application/json", produces = "application/json")
    ResponseEntity<Boolean> checkCommunityStatusById(@PathVariable(value = "id") UUID id);
}

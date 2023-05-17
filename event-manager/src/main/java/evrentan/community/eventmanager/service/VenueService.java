package evrentan.community.eventmanager.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

/**
 * Venue Service Interface Class to call venue service within venue manager
 *
 * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
 * @since 1.0.0
 */
@FeignClient(value = "venue-service")
public interface VenueService {

    /**
     * Check venue status by venue id.
     *
     * @param id room id to be checked.
     * @return Boolean. true if Venue is active, otherwise false.
     *
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    @GetMapping(value = "/venue/checkVenueStatus/{id}", consumes = "application/json", produces = "application/json")
    Boolean checkVenueStatusById(@PathVariable UUID id);
}

package evrentan.community.eventmanager.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

/**
 * Room Service Interface Class to call room service within venue manager
 *
 * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
 * @since 1.0.0
 */
@FeignClient(value = "venue-manager")
public interface RoomService {

    /**
     * Check room status by room id and participant limit according to room capacity.
     *
     * @param id room id to be checked.
     * @param participantLimit which the max number of participants for the event.
     * @return Boolean. true if room status is okay (room is active and room capacity is enough), otherwise false.
     *
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    @GetMapping(value = "/room/checkRoomStatus/{id}/{participantLimit}", consumes = "application/json", produces = "application/json")
    Boolean checkRoomStatusByIdAndCapacity(@PathVariable UUID id, @PathVariable Integer participantLimit);
}

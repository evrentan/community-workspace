package evrentan.community.eventmanager.controller;

import evrentan.community.eventmanager.dto.EventDto;
import evrentan.community.eventmanager.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.net.URI;

/**
 * REST Controller for community related API end-points.
 *
 * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
 * @since 1.0.0
 */

@RestController
@RequestMapping(value = "/event", produces = "application/json", consumes = "application/json")
@Tag(name = "Event Related APIs")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    /**
     * REST end-point in order to create an event.
     * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
     *
     * @param eventDto object that is going to be created. Please, see the {@link EventDto} class for details.
     * @return EventDto Object within ResponseEntity.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    @PostMapping
    @Operation(summary = "Creat a Event")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description  = "Successfully Community Created"),
            @ApiResponse(responseCode  = "400", description  = "Bad Request"),
            @ApiResponse(responseCode  = "404", description  = "Not Found"),
            @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
    })
    public ResponseEntity<EventDto> createEvent(@RequestBody @NotNull EventDto eventDto){
        final EventDto eventCreated = this.eventService.createEvent(eventDto);
        return ResponseEntity.created(URI.create(eventCreated.getId().toString())).body(eventCreated);
    }
}

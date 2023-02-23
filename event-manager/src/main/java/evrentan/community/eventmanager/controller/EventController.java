package evrentan.community.eventmanager.controller;

import evrentan.community.eventmanager.dto.EventDto;
import evrentan.community.eventmanager.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;
import java.util.UUID;

/**
 * REST Controller for event related API end-points.
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
    @Operation(summary = "Creat an Event")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description  = "Successfully Event Created"),
            @ApiResponse(responseCode  = "400", description  = "Bad Request"),
            @ApiResponse(responseCode  = "404", description  = "Not Found"),
            @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
    })
    public ResponseEntity<EventDto> createEvent(@RequestBody @NotNull EventDto eventDto){
        final EventDto eventCreated = this.eventService.createEvent(eventDto);
        return ResponseEntity.created(URI.create(this.eventService.createEvent(eventDto).getId().toString())).body(eventCreated);
    }

    /**
     * REST end-point in order to delete a specific event object by event ID.
     * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
     *
     * @param id is the event id that is going to be deleted.
     * @return EventDto Object within ResponseEntity. Please, see the {@link EventDto} class for details.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    @PatchMapping(value = "/updateEventStatus")
    @Operation(summary = "Update a Event Status by Id & Status value")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description  = "Successfully Update the Related Event Status"),
            @ApiResponse(responseCode  = "400", description  = "Bad Request"),
            @ApiResponse(responseCode  = "404", description  = "Not Found"),
            @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
    })
    public ResponseEntity<EventDto> updateEventStatus(@RequestParam(value = "id") @NotNull UUID id, @RequestBody @NotNull EventDto eventDto){
        return ResponseEntity.ok(this.eventService.updateEventStatus(id,eventDto.isActive()));
    }

    /**
     * REST end-point in order to get all events.
     * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
     *
     * @return List of EventDto Object within ResponseEntity. Please, see the {@link EventDto} class for details.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    @GetMapping
    @Operation(summary = "Get All Events")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description  = "Successfully Get All Events"),
            @ApiResponse(responseCode  = "400", description  = "Bad Request"),
            @ApiResponse(responseCode  = "404", description  = "Not Found"),
            @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
    })
    public ResponseEntity<List<EventDto>> getAllEvents(){
        return ResponseEntity.ok(this.eventService.getAllEvents());
    }

    /**
     * REST end-point in order to retrieve a specific event object by event ID.
     * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
     *
     * @param id is the event id that is going to be retrieved.
     * @return EventDto Object within ResponseEntity. Please, see the {@link EventDto} class for details.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    @GetMapping(value = "/{id}")
    @Operation(summary = "Get an Event by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description  = "Successfully Get the Related Community"),
            @ApiResponse(responseCode  = "400", description  = "Bad Request"),
            @ApiResponse(responseCode  = "404", description  = "Not Found"),
            @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
    })
    public ResponseEntity<EventDto> getEvent(@PathVariable(value = "id") UUID id){
        return ResponseEntity.ok(this.eventService.getEvent(id));
    }



}

package evrentan.community.eventmanager.controller;

import evrentan.community.eventmanager.dto.entity.Event;
import evrentan.community.eventmanager.dto.request.CreateEventRequest;
import evrentan.community.eventmanager.dto.response.CreateEventResponse;
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
@Tag(name = "EventEntity Related APIs")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    /**
     * REST end-point in order to create an event.
     * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
     *
     * @param createEventRequest object that is going to be created. Please, see the {@link CreateEventRequest} class for details.
     * @return Event Object within ResponseEntity.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    @PostMapping
    @Operation(summary = "Creat an EventEntity")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description  = "Successfully EventEntity Created"),
            @ApiResponse(responseCode  = "400", description  = "Bad Request"),
            @ApiResponse(responseCode  = "404", description  = "Not Found"),
            @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
    })
    public ResponseEntity<CreateEventResponse> createEvent(@RequestBody @NotNull CreateEventRequest createEventRequest){
        final CreateEventResponse createEventResponse = this.eventService.createEvent(createEventRequest);
        return ResponseEntity.created(URI.create(createEventResponse.getId().toString())).body(createEventResponse);
    }

    /**
     * REST end-point in order to delete a specific event object by event ID.
     * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
     *
     * @param id is the event id that is going to be deleted.
     * @return Event Object within ResponseEntity. Please, see the {@link Event} class for details.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    @PatchMapping(value = "/updateEventStatus")
    @Operation(summary = "Update a EventEntity Status by Id & Status value")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description  = "Successfully Update the Related EventEntity Status"),
            @ApiResponse(responseCode  = "400", description  = "Bad Request"),
            @ApiResponse(responseCode  = "404", description  = "Not Found"),
            @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
    })
    public ResponseEntity<Event> updateEventStatus(@RequestParam(value = "id") @NotNull UUID id, @RequestBody @NotNull Event event){
        return ResponseEntity.ok(this.eventService.updateEventStatus(id, event.isActive()));
    }

    /**
     * REST end-point in order to get all events.
     * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
     *
     * @return List of Event Object within ResponseEntity. Please, see the {@link Event} class for details.
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
    public ResponseEntity<List<Event>> getAllEvents(){
        return ResponseEntity.ok(this.eventService.getAllEvents());
    }

    /**
     * REST end-point in order to retrieve a specific event object by event ID.
     * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
     *
     * @param id is the event id that is going to be retrieved.
     * @return Event Object within ResponseEntity. Please, see the {@link Event} class for details.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    @GetMapping(value = "/{id}")
    @Operation(summary = "Get an EventEntity by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description  = "Successfully Get the Related Community"),
            @ApiResponse(responseCode  = "400", description  = "Bad Request"),
            @ApiResponse(responseCode  = "404", description  = "Not Found"),
            @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
    })
    public ResponseEntity<Event> getEvent(@PathVariable(value = "id") UUID id){
        return ResponseEntity.ok(this.eventService.getEvent(id));
    }

    /**
     * REST end-point in order to update a specific event object by event ID.
     * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
     *
     * @param id is the event id that is going to be updated.
     * @param event is the new object that is going to be updated within the existing one. Please, see the {@link Event} class for details.
     * @return Event Object within ResponseEntity. Please, see the {@link Event} class for details.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
     @PutMapping(value = "/{id}")
     @Operation(summary = "Update an EventEntity by Id")
     @ApiResponses(value = {
             @ApiResponse(responseCode  = "200", description  = "Successfully Update the Related Community"),
             @ApiResponse(responseCode  = "400", description  = "Bad Request"),
             @ApiResponse(responseCode  = "404", description  = "Not Found"),
             @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
     })
    public ResponseEntity<Event> updateEvent(@PathVariable(value = "id") UUID id, @RequestBody @NotNull Event event){
         return ResponseEntity.ok(this.eventService.updateEvent(id, event));
     }



}

package evrentan.community.venuemanager.controller;

import evrentan.community.venuemanager.dto.Venue;
import evrentan.community.venuemanager.dto.VenueRoom;
import evrentan.community.venuemanager.service.VenueService;
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
 * REST Controller for venue related API end-points.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/venue", produces = "application/json", consumes = "application/json")
@Tag(name = "Venue Related APIs")
public class VenueController {

  private final VenueService venueService;

  public VenueController(VenueService venueService) {
    this.venueService = venueService;
  }

  /**
   * REST end-point in order to create a venue.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param venue object that is going to be created. Please, see the {@link Venue} class for details.
   * @return Venue Object within ResponseEntity.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @PostMapping
  @Operation(summary = "Create a Venue")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "201", description  = "Successfully Venue Created"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<Venue> createVenue(@RequestBody @NotNull Venue venue) {
    final Venue venueCreated = this.venueService.createVenue(venue);
    return ResponseEntity.created(URI.create(venueCreated.getId().toString())).body(venueCreated);
  }

  /**
   * REST end-point in order to get all venues.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @return List of Venue Object within ResponseEntity. Please, see the {@link Venue} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @GetMapping
  @Operation(summary = "Get All Venues")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Get All Venues"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<List<Venue>> getAllVenues() {
    return ResponseEntity.ok(this.venueService.getVenues());
  }

  /**
   * REST end-point in order to retrieve a specific venue object by venue ID.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param id is the venue id that is going to be retrieved.
   * @return Venue Object within ResponseEntity. Please, see the {@link Venue} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @GetMapping(value = "/{id}")
  @Operation(summary = "Get a Venue by Id")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Get the Related Venue"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<Venue> getVenue(@PathVariable(value = "id") UUID id) {
    return ResponseEntity.ok(this.venueService.getVenue(id));
  }

  /**
   * REST end-point in order to check a specific venue status object by venue ID.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param id is the venue id that is going to be retrieved.
   * @return Boolean. true if Venue is active, otherwise false
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @GetMapping(value = "/checkVenueStatus/{id}")
  @Operation(summary = "Check a Venue Status by Id")
  @ApiResponses(value = {
          @ApiResponse(responseCode  = "200", description  = "Successfully Get the Related Venue"),
          @ApiResponse(responseCode  = "400", description  = "Bad Request"),
          @ApiResponse(responseCode  = "404", description  = "Not Found"),
          @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<Boolean> checkVenueStatusById(@PathVariable(value = "id") UUID id) {
    return ResponseEntity.ok(this.venueService.checkVenueStatusById(id));
  }

  /**
   * REST end-point in order to update a specific venue object by venue ID.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param id is the venue id that is going to be updated.
   * @param venue is the new object that is going to be updated within the existing one. Please, see the {@link Venue} class for details.
   * @return Venue Object within ResponseEntity. Please, see the {@link Venue} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @PutMapping(value = "/{id}")
  @Operation(summary = "Update a Venue by Id")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "202", description  = "Successfully Update the Related Venue"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<Venue> updateVenue(@PathVariable(value = "id") UUID id, @RequestBody @NotNull Venue venue) {
    return ResponseEntity.accepted().body(this.venueService.updateVenue(id, venue));
  }

  /**
   * REST end-point in order to update a specific venue object status by venue ID.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param id is the venue id that is going to be deleted.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @PatchMapping(value = "/updateVenueStatus")
  @Operation(summary = "Update a Venue Status by Id & Status value")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "202", description  = "Successfully Update the Related Venue Status"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity updateVenueStatus(@RequestParam(value = "id") @NotNull UUID id, @RequestBody @NotNull Venue venue) {
    this.venueService.updateVenueStatus(id, venue.isActive());
    return ResponseEntity.accepted().build();
  }

  /**
   * REST end-point in order to add room(s) to a specific venue object by venue ID.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param venueId is the venue id that is going to be updated.
   * @param addedVenueRoomList is the new object that is going to be added to the existing one. Please, see the {@link VenueRoom} class for details.
   * @return ResponseEntity. Please, see the {@link ResponseEntity} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @PatchMapping(value = "/addRooms")
  @Operation(summary = "Add Room(s) to the Related Venue")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "202", description  = "Successfully Add Room(s) from the Related Venue"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity addRoom(@RequestParam(value = "id") @NotNull UUID venueId, @RequestBody @NotNull List<VenueRoom> addedVenueRoomList) {
    this.venueService.addRooms(venueId, addedVenueRoomList);
    return ResponseEntity.accepted().build();
  }

  /**
   * REST end-point in order to add room(s) to a specific venue object by venue ID.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param venueId is the venue id that is going to be updated.
   * @param removedVenueRoomList is the new object that is going to be added to the existing one. Please, see the {@link VenueRoom} class for details.
   * @return ResponseEntity. Please, see the {@link ResponseEntity} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @PatchMapping(value = "/removeRooms")
  @Operation(summary = "Remove Room(s) from the Related Venue")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "202", description  = "Successfully Remove Room(s) from the Related Venue"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity removeRoom(@RequestParam(value = "id") @NotNull UUID venueId, @RequestBody @NotNull List<VenueRoom> removedVenueRoomList) {
    this.venueService.removeRooms(venueId, removedVenueRoomList);
    return ResponseEntity.accepted().build();
  }
}
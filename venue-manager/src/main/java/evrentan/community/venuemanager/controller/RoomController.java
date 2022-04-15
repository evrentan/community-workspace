package evrentan.community.venuemanager.controller;

import evrentan.community.venuemanager.dto.Room;
import evrentan.community.venuemanager.dto.VenueRoom;
import evrentan.community.venuemanager.service.RoomService;
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
 * REST Controller for room related API end-points.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/room", produces = "application/json", consumes = "application/json")
@Tag(name = "Room Related APIs")
public class RoomController {

  private final RoomService roomService;

  public RoomController(RoomService roomService) {
    this.roomService = roomService;
  }

  /**
   * REST end-point in order to create a room.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param room object that is going to be created. Please, see the {@link Room} class for details.
   * @return Room Object within ResponseEntity.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @PostMapping
  @Operation(summary = "Create a Room")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Room Created"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<Room> createRoom(@RequestBody @NotNull Room room) {
    final Room roomCreated = this.roomService.createRoom(room);
    return ResponseEntity.created(URI.create(roomCreated.getId().toString())).body(roomCreated);
  }

  /**
   * REST end-point in order to get all rooms.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @return List of Room Object within ResponseEntity. Please, see the {@link Room} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @GetMapping
  @Operation(summary = "Get All Rooms")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Get All Rooms"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<List<Room>> getAllRooms() {
    return ResponseEntity.ok(this.roomService.getRooms());
  }

  /**
   * REST end-point in order to retrieve a specific room object by room ID.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param id is the room id that is going to be retrieved.
   * @return Room Object within ResponseEntity. Please, see the {@link Room} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @GetMapping(value = "/{id}")
  @Operation(summary = "Get a Room by Id")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Get the Related Room"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<Room> getRoom(@PathVariable(value = "id") UUID id) {
    return ResponseEntity.ok(this.roomService.getRoom(id));
  }

  /**
   * REST end-point in order to update a specific room object by room ID.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param id is the room id that is going to be updated.
   * @param room is the new object that is going to be updated within the existing one. Please, see the {@link Room} class for details.
   * @return Room Object within ResponseEntity. Please, see the {@link Room} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @PutMapping(value = "/{id}")
  @Operation(summary = "Update a Room by Id")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Update the Related Room"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<Room> updateRoom(@PathVariable(value = "id") UUID id, @RequestBody @NotNull Room room) {
    return ResponseEntity.ok(this.roomService.updateRoom(id, room));
  }

  /**
   * REST end-point in order to delete a specific room object by room ID.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param id is the room id that is going to be deleted.
   * @return Room Object within ResponseEntity. Please, see the {@link Room} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @PatchMapping(value = "/updateRoomStatus")
  @Operation(summary = "Update a Room Status by Id & Status value")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Update the Related Room Status"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<Room> updateRoomStatus(@RequestParam(value = "id") @NotNull UUID id, @RequestBody @NotNull Room room) {
    return ResponseEntity.ok(this.roomService.updateRoomStatus(id, room.isActive()));
  }

  /**
   * REST end-point in order to assign a room to a venue.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param venueId is the venue id that is going to be updated.
   * @param assignedVenueRoom is the new object that is going to be added to the existing one. Please, see the {@link VenueRoom} class for details.
   * @return ResponseEntity. Please, see the {@link ResponseEntity} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @PatchMapping(value = "/assignToVenue")
  @Operation(summary = "Add Room(s) to the Related Venue")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Add Room(s) from the Related Venue"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity assignToVenue(@RequestParam(value = "id") @NotNull UUID venueId, @RequestBody @NotNull VenueRoom assignedVenueRoom) {
    UUID venueRoomUuid = this.roomService.assignToVenue(venueId, assignedVenueRoom);
    return ResponseEntity.created(URI.create(venueRoomUuid.toString())).build();
  }

  /**
   * REST end-point in order to add room(s) to a specific venue object by venue ID.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param venueId is the venue id that is going to be updated.
   * @param removedVenueRoom is the new object that is going to be added to the existing one. Please, see the {@link VenueRoom} class for details.
   * @return ResponseEntity. Please, see the {@link ResponseEntity} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @PatchMapping(value = "/removeFromVenue")
  @Operation(summary = "Remove Room(s) from the Related Venue")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Remove Room(s) from the Related Venue"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity removeRoom(@RequestParam(value = "id") @NotNull UUID venueId, @RequestBody @NotNull VenueRoom removedVenueRoom) {
    this.roomService.removeFromVenue(venueId, removedVenueRoom);
    return ResponseEntity.accepted().build();
  }
}
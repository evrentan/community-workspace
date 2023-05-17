package evrentan.community.venuemanager.service;

import evrentan.community.venuemanager.dto.Room;
import evrentan.community.venuemanager.dto.VenueRoom;

import java.util.List;
import java.util.UUID;

/**
 * Room Service Interface Class
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
public interface RoomService {

  /**
   * Create a room instance in the database
   *
   * @param room room to be created. Please, see the {@link Room} class for details.
   * @return Room which is created. Please, see the {@link Room} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  Room createRoom(Room room);

  /**
   * Return all room instances in the database
   *
   * @return List<Room>. Please, see the {@link Room} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  List<Room> getRooms();

  /**
   * Return a room instance by using its id in the database
   *
   * @param id room id to be filtered
   * @return Room. Please, see the {@link Room} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  Room getRoom(UUID id);

  /**
   * Return true if room status is okay (room is active and room capacity is enough), otherwise false
   *
   * @param id is the room id that is going to be retrieved.
   * @param participantLimit is the limit of the event.
   * @return Boolean. true if room status is okay (room is active and room capacity is enough), otherwise false.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  Boolean checkRoomStatusByIdAndCapacity(UUID id, Integer participantLimit);

  /**
   * Update a room instance in the database
   *
   * @param id room id to be updated.
   * @param room room instance to be updated. Please, see the {@link Room} class for details.
   * @return Room which is updated. Please, see the {@link Room} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  Room updateRoom(UUID id, Room room);

  /**
   * Update a room status instance in the database
   *
   * @param id room id to be updated.
   * @param status status of the room to be updated.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  void updateRoomStatus(UUID id, boolean status);

  /**
   * Assign a room to a venue
   *
   * @param roomId room id to be assigned to the venue
   * @param assignedVenueRoom venue that the room is assigned to
   * @return UUID which is the id of the VenueRoom instance. Please, see the {@link evrentan.community.venuemanager.dto.VenueRoom} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  UUID assignToVenue(UUID roomId, VenueRoom assignedVenueRoom);

  /**
   * Remove a room from a venue
   *
   * @param id room id to be removed to the venue
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  void removeFromVenue(UUID id);
}
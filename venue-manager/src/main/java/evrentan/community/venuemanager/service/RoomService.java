package evrentan.community.venuemanager.service;

import evrentan.community.venuemanager.dto.Room;

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
  Room updateRoomStatus(UUID id, boolean status);
}
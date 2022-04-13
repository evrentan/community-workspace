package evrentan.community.venuemanager.impl;

import evrentan.community.venuemanager.dto.Room;
import evrentan.community.venuemanager.entity.RoomEntity;
import evrentan.community.venuemanager.mapper.RoomMapper;
import evrentan.community.venuemanager.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

/**
 * Room Service Implementation for Room Service Layer.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Service
public class RoomServiceImpl implements evrentan.community.venuemanager.service.RoomService {

  private final RoomRepository roomRepository;

  public RoomServiceImpl(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  /**
   * Create a room instance in the database
   *
   * @param room room to be created. Please, see the {@link Room} class for details.
   * @return Room which is created. Please, see the {@link Room} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public Room createRoom(Room room) {
    return RoomMapper.toDto(this.roomRepository.save(RoomMapper.toEntity(room)));
  }

  /**
   * Return all room instances in the database
   *
   * @return List<Room>. Please, see the {@link Room} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public List<Room> getRooms() {
    return RoomMapper.toDtoList(this.roomRepository.findAll());
  }

  /**
   * Return a room instance by using its id in the database
   *
   * @param id room id to be filtered
   * @return Room. Please, see the {@link Room} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public Room getRoom(UUID id) {
    return RoomMapper.toDto(this.roomRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Room not found")));
  }

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
  @Override
  public Room updateRoom(UUID id, Room room) {
    if(!Objects.equals(id, room.getId()))
      throw new IllegalArgumentException("Ids do not match");

    if (!this.roomRepository.existsById(id))
      throw new NoSuchElementException("Room not found");

    return RoomMapper.toDto(this.roomRepository.save(RoomMapper.toEntity(room)));
  }

  /**
   * Update a room status instance in the database
   *
   * @param id room id to be updated.
   * @param status status of the room to be updated.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public Room updateRoomStatus(UUID id, boolean status) {
    RoomEntity roomEntity = this.roomRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Room not found"));
    roomEntity.setActive(status);

    return RoomMapper.toDto(this.roomRepository.save(roomEntity));
  }
}
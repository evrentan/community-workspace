package evrentan.community.venuemanager.impl;

import evrentan.community.venuemanager.dto.Room;
import evrentan.community.venuemanager.dto.VenueRoom;
import evrentan.community.venuemanager.entity.RoomEntity;
import evrentan.community.venuemanager.mapper.RoomMapper;
import evrentan.community.venuemanager.mapper.VenueRoomMapper;
import evrentan.community.venuemanager.repository.RoomRepository;
import evrentan.community.venuemanager.service.VenueService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Room Service Implementation for Room Service Layer.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Service
public class RoomServiceImpl implements evrentan.community.venuemanager.service.RoomService {

  private static final String ROOM_NOT_FOUND = "Room does not exist !!!";

  private final RoomRepository roomRepository;
  private final VenueRoomRepository venueRoomRepository;
  private final VenueService venueService;

  public RoomServiceImpl(RoomRepository roomRepository, VenueRoomRepository venueRoomRepository, VenueService venueService) {
    this.roomRepository = roomRepository;
    this.venueRoomRepository = venueRoomRepository;
    this.venueService = venueService;
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
    if (!Objects.equals(id, room.getId()))
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
  public void updateRoomStatus(UUID id, boolean status) {
    RoomEntity roomEntity = this.roomRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Room not found"));
    roomEntity.setActive(status);
    this.roomRepository.save(roomEntity);

    if (!status)
      this.removeRoomFromVenue(id);
  }

  /**
   * Assign a room to a venue
   *
   * @param roomId room id to be assigned to the venue
   * @param assignedVenueRoom venue that the room is assigned to
   * @return UUID which is the id of the VenueRoom instance. Please, see the {@link VenueRoom} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public UUID assignToVenue(UUID roomId, VenueRoom assignedVenueRoom) {
    this.checkRoomExists(roomId);
    this.venueService.checkVenueExists(assignedVenueRoom.getVenueId());
    VenueRoom venueRoom = VenueRoomMapper.toDto(this.venueRoomRepository.findByVenueIdAndRoomId(assignedVenueRoom.getVenueId(), roomId));

    if (Objects.isNull(venueRoom)) {
      return this.createVenueRoomWithRoomIdAndVenueRoom(roomId, assignedVenueRoom).getId();
    } else if (!venueRoom.isActive()) {
      venueRoom.setActive(true);
      this.venueRoomRepository.save(VenueRoomMapper.toEntity(venueRoom));
      return venueRoom.getId();
    }

    return venueRoom.getId();
  }

  /**
   * Remove a room from a venue
   *
   * @param roomId room id to be removed to the venue
   * @param removedVenueRoom venue that the room is removed from
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  public void removeFromVenue(UUID roomId, VenueRoom removedVenueRoom) {
    this.checkRoomExists(roomId);
    this.venueService.checkVenueExists(removedVenueRoom.getVenueId());
    List<VenueRoom> venueRoomList = VenueRoomMapper.toDtoList(this.venueRoomRepository.findAllByVenueIdAndRoomIdInAndActive(removedVenueRoom.getVenueId(), Collections.singletonList(roomId), true));

    venueRoomList.forEach(venueRoom -> venueRoom.setActive(false));

    this.venueRoomRepository.saveAll(VenueRoomMapper.toEntityList(venueRoomList));
  }

  /**
   * Check if the venue exists by venue ID
   * @param id is the venue id that is going to be checked.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  private void checkRoomExists(UUID id) {
    if (Objects.isNull(id) || !this.roomRepository.existsById(id))
      throw new NoSuchElementException(ROOM_NOT_FOUND);
  }

  /**
   * Create a venue room instance with room id and venue room instance.
   *
   * @param roomId is the room id that is going to be assigned to the venue
   * @param assignedVenueRoom is the venue that the room is assigned to
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  private VenueRoom createVenueRoomWithRoomIdAndVenueRoom(UUID roomId, VenueRoom assignedVenueRoom) {
    VenueRoom venueRoom = new VenueRoom();
    venueRoom.setVenueId(assignedVenueRoom.getVenueId());
    venueRoom.setRoomId(roomId);
    venueRoom.setActive(true);
    return VenueRoomMapper.toDto(this.venueRoomRepository.save(VenueRoomMapper.toEntity(venueRoom)));
  }

  /**
   * Remove a room from a venue
   * @param id is the room id that is going to be removed from the venue
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  private void removeRoomFromVenue(UUID id) {
    List<VenueRoom> activeVenueRoomListByRoomId = VenueRoomMapper.toDtoList(this.venueRoomRepository.findAllByRoomIdAndActive(id, true));
    if (!activeVenueRoomListByRoomId.isEmpty()) {
      activeVenueRoomListByRoomId.forEach(venueRoom -> venueRoom.setActive(false));
      this.venueRoomRepository.saveAll(VenueRoomMapper.toEntityList(activeVenueRoomListByRoomId));
    }
  }
}
package evrentan.community.venuemanager.mapper;

import evrentan.community.venuemanager.dto.Room;
import evrentan.community.venuemanager.entity.RoomEntity;

import java.util.List;
import java.util.Objects;

/**
 * Room Mapper Class which maps RoomEntity to Room and vice versa.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
public class RoomMapper {

  private RoomMapper() {
    throw new IllegalStateException(String.format("%s is a utility class", this.getClass().getCanonicalName()));
  }

  /**
   * Maps Room to RoomEntity.
   * @param room Entity to be mapped. Please, see the {@link Room} class for details.
   * @return RoomEntity. Please, see the {@link RoomEntity} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static RoomEntity toEntity(Room room) {
    if(Objects.isNull(room))
      return null;

    return RoomEntity.builder()
        .id(room.getId())
        .name(room.getName())
        .description(room.getDescription())
        .capacity(room.getCapacity())
        .active(room.isActive())
        .build();
  }

  /**
   * Maps RoomEntity to Room.
   * @param roomEntity Entity to be mapped. Please, see the {@link RoomEntity} class for details.
   * @return Room. Please, see the {@link Room} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static Room toDto(RoomEntity roomEntity) {
    if(Objects.isNull(roomEntity))
      return null;

    return Room.builder()
        .id(roomEntity.getId())
        .name(roomEntity.getName())
        .description(roomEntity.getDescription())
        .capacity(roomEntity.getCapacity())
        .active(roomEntity.isActive())
        .build();
  }

  /**
   * Maps List of Room to List of RoomEntity.
   *
   * @param venueList List of entities to be mapped. Please, see the {@link Room} class for details.
   * @return List of RoomEntity. Please, see the {@link RoomEntity} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static List<RoomEntity> toEntityList(List<Room> venueList) {
    return venueList.stream().parallel()
        .map(RoomMapper::toEntity)
        .toList();
  }

  /**
   * Maps List of RoomEntity to List of Room.
   *
   * @param roomEntityList List of entities to be mapped. Please, see the {@link RoomEntity} class for details.
   * @return List of Room. Please, see the {@link Room} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static List<Room> toDtoList(List<RoomEntity> roomEntityList) {
    return roomEntityList.stream().parallel()
        .map(RoomMapper::toDto)
        .toList();
  }
}
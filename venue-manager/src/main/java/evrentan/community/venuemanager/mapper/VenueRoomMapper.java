package evrentan.community.venuemanager.mapper;

import evrentan.community.venuemanager.dto.VenueRoom;
import evrentan.community.venuemanager.entity.VenueRoomEntity;

import java.util.List;
import java.util.Objects;

/**
 * VenueRoom Mapper Class which maps VenueRoomEntity to VenueRoom and vice versa.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
public class VenueRoomMapper {

  private VenueRoomMapper() {
    throw new IllegalStateException(String.format("%s is a utility class", this.getClass().getCanonicalName()));
  }

  /**
   * Maps VenueRoom to VenueRoomEntity.
   * @param venueRoom Entity to be mapped. Please, see the {@link VenueRoom} class for details.
   * @return VenueRoomEntity. Please, see the {@link VenueRoomEntity} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static VenueRoomEntity toEntity(VenueRoom venueRoom) {
    if(Objects.isNull(venueRoom))
      return null;

    return VenueRoomEntity.builder()
        .id(venueRoom.getId())
        .venueId(venueRoom.getVenueId())
        .roomId(venueRoom.getRoomId())
        .active(venueRoom.isActive())
        .build();
  }

  /**
   * Maps VenueRoomEntity to VenueRoom.
   * @param venueRoomEntity Entity to be mapped. Please, see the {@link VenueRoomEntity} class for details.
   * @return VenueRoom. Please, see the {@link VenueRoom} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static VenueRoom toDto(VenueRoomEntity venueRoomEntity) {
    if(Objects.isNull(venueRoomEntity))
      return null;

    return VenueRoom.builder()
        .id(venueRoomEntity.getId())
        .venueId(venueRoomEntity.getVenueId())
        .roomId(venueRoomEntity.getRoomId())
        .active(venueRoomEntity.isActive())
        .build();
  }

  /**
   * Maps List of VenueRoom to List of VenueRoomEntity.
   *
   * @param venueRoomList List of entities to be mapped. Please, see the {@link VenueRoom} class for details.
   * @return List of VenueRoomEntity. Please, see the {@link VenueRoomEntity} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static List<VenueRoomEntity> toEntityList(List<VenueRoom> venueRoomList) {
    return venueRoomList.stream().parallel()
        .map(VenueRoomMapper::toEntity)
        .toList();
  }

  /**
   * Maps List of VenueRoomEntity to List of VenueRoom.
   *
   * @param venueRoomEntityList List of entities to be mapped. Please, see the {@link VenueRoomEntity} class for details.
   * @return List of VenueRoom. Please, see the {@link VenueRoom} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static List<VenueRoom> toDtoList(List<VenueRoomEntity> venueRoomEntityList) {
    return venueRoomEntityList.stream().parallel()
        .map(VenueRoomMapper::toDto)
        .toList();
  }
}
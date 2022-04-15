package evrentan.community.venuemanager.mapper;

import evrentan.community.venuemanager.dto.Venue;
import evrentan.community.venuemanager.entity.VenueEntity;

import java.util.List;
import java.util.Objects;

/**
 * Venue Mapper Class which maps VenueEntity to Venue and vice versa.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
public class VenueMapper {

  private VenueMapper() {
    throw new IllegalStateException(String.format("%s is a utility class", this.getClass().getCanonicalName()));
  }

  /**
   * Maps Venue to VenueEntity.
   * @param venue Entity to be mapped. Please, see the {@link Venue} class for details.
   * @return VenueEntity. Please, see the {@link VenueEntity} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static VenueEntity toEntity(Venue venue) {
    if(Objects.isNull(venue))
      return null;

    return VenueEntity.builder()
        .id(venue.getId())
        .name(venue.getName())
        .description(venue.getDescription())
        .city(venue.getCity())
        .address(venue.getAddress())
        .active(venue.isActive())
        .build();
  }

  /**
   * Maps VenueEntity to Venue.
   * @param venueEntity Entity to be mapped. Please, see the {@link VenueEntity} class for details.
   * @return Venue. Please, see the {@link Venue} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static Venue toDto(VenueEntity venueEntity) {
    if(Objects.isNull(venueEntity))
      return null;

    return Venue.builder()
        .id(venueEntity.getId())
        .name(venueEntity.getName())
        .description(venueEntity.getDescription())
        .city(venueEntity.getCity())
        .address(venueEntity.getAddress())
        .active(venueEntity.isActive())
        .build();
  }

  /**
   * Maps List of Venue to List of VenueEntity.
   *
   * @param venueList List of entities to be mapped. Please, see the {@link Venue} class for details.
   * @return List of VenueEntity. Please, see the {@link VenueEntity} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static List<VenueEntity> toEntityList(List<Venue> venueList) {
    return venueList.stream().parallel()
        .map(VenueMapper::toEntity)
        .toList();
  }

  /**
   * Maps List of VenueEntity to List of Venue.
   *
   * @param venueEntityList List of entities to be mapped. Please, see the {@link VenueEntity} class for details.
   * @return List of Venue. Please, see the {@link Venue} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static List<Venue> toDtoList(List<VenueEntity> venueEntityList) {
    return venueEntityList.stream().parallel()
        .map(VenueMapper::toDto)
        .toList();
  }
}
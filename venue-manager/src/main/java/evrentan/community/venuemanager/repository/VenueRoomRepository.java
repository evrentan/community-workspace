package evrentan.community.venuemanager.repository;

import evrentan.community.venuemanager.entity.VenueRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Repository for VenueRoomEntity
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Repository
public interface VenueRoomRepository extends JpaRepository<VenueRoomEntity, UUID> {

  /**
   * Find all VenueRoomEntity by venue id. Please, see the {@link VenueRoomEntity} class for details.
   *
   * @param venueId The venue id to find all related VenueRoomEntity.
   * @return List of VenueRoomEntity
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  List<VenueRoomEntity> findAllByVenueId(UUID venueId);

  /**
   * Find all VenueRoomEntity by venue id, list of room id and active. Please, see the {@link VenueRoomEntity} class for details.
   *
   * @param venueId The venue id to find all related VenueRoomEntity.
   * @param roomIds The list of room id to find all related VenueRoomEntity.
   * @param active The active to find all related VenueRoomEntity.
   * @return List of VenueRoomEntity
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  List<VenueRoomEntity> findAllByVenueIdAndRoomIdInAndActive(UUID venueId, List<UUID> roomIds, boolean active);

  /**
   * Find the VenueRoomEntity by venue id and room id. Please, see the {@link VenueRoomEntity} class for details.
   *
   * @param venueId The venue id to find the related VenueRoomEntity.
   * @param roomId  The room id to find the related VenueRoomEntity.
   * @return The related VenueRoomEntity
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  VenueRoomEntity findByVenueIdAndRoomId(UUID venueId, UUID roomId);

  /**
   * Find all VenueRoomEntity by venue id and active. Please, see the {@link VenueRoomEntity} class for details.
   *
   * @param venueId The venue id to find all related VenueRoomEntity.
   * @param active The active to find all related VenueRoomEntity.
   * @return List of VenueRoomEntity
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  List<VenueRoomEntity> findAllByVenueIdAndActive(UUID venueId, boolean active);

  /**
   * Find all VenueRoomEntity by room id and active. Please, see the {@link VenueRoomEntity} class for details.
   *
   * @param roomId The venue id to find all related VenueRoomEntity.
   * @param active The active to find all related VenueRoomEntity.
   * @return List of VenueRoomEntity
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  List<VenueRoomEntity> findAllByRoomIdAndActive(UUID roomId, boolean active);
}

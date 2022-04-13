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

  List<VenueRoomEntity> findAllByVenueId(UUID venueId);

  List<VenueRoomEntity> findAllByVenueIdAndRoomIdInAndActive(UUID venueId, List<UUID> roomIds, boolean active);

  List<VenueRoomEntity> findAllByVenueIdAndActive(UUID venueId, boolean active);
}

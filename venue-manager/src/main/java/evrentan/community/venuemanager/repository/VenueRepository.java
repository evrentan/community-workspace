package evrentan.community.venuemanager.repository;

import evrentan.community.venuemanager.entity.VenueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for VenueEntity
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Repository
public interface VenueRepository extends JpaRepository<VenueEntity, UUID> {

  /**
   * Find the VenueEntity by venue id and active. Please, see the {@link VenueEntity} class for details.
   *
   * @param id The venue id to find the related VenueEntity.
   * @param active The active status to find the related VenueEntity.
   * @return The related VenueEntity.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  VenueEntity findByIdAndActive(UUID id, boolean active);
}

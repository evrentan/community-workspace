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

  VenueEntity findByIdAndActive(UUID id, boolean active);
}

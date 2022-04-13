package evrentan.community.venuemanager.repository;

import evrentan.community.venuemanager.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for RoomEntity
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {
}

package evrentan.community.eventmanager.repository;

import evrentan.community.eventmanager.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for EventEntity
 *
 * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
 * @since 1.0.0
 */
@Repository
public interface EventRepository extends JpaRepository<EventEntity, UUID> {

}

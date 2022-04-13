package evrentan.community.communitymanager.repository;

import evrentan.community.communitymanager.entity.CommunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for CommunityEntity
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Repository
public interface CommunityRepository extends JpaRepository<CommunityEntity, UUID> {
}

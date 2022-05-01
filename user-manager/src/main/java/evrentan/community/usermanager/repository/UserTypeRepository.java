package evrentan.community.usermanager.repository;

import evrentan.community.usermanager.entity.UserTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for UserTypeEntity
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Repository
public interface UserTypeRepository extends JpaRepository<UserTypeEntity, UUID> {
}

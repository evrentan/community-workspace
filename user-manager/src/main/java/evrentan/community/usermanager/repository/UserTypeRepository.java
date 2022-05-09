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

  /**
   * Check whether a user type exists by its code in the database
   *
   * @param code the code of the user type
   * @return true if the user exists, false otherwise
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  boolean existsDistinctByCode(String code);
}

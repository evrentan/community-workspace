package evrentan.community.usermanager.repository;

import evrentan.community.usermanager.entity.ApplicationUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository for ApplicationUserEntity
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUserEntity, UUID> {

  /**
   * Check whether a user exists by its email in the database
   *
   * @param email the email of the user
   * @return true if the user exists, false otherwise
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  boolean existsDistinctByEmail(String email);

  /**
   * Find a user by its email in the database
   *
   * @param email the email of the user
   * @return ApplicationUserEntity. ApplicationUser. Please, see the {@link ApplicationUserEntity} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  Optional<ApplicationUserEntity> findByEmail(String email);

}

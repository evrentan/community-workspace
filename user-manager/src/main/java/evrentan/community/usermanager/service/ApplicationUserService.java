package evrentan.community.usermanager.service;

import evrentan.community.usermanager.dto.ApplicationUser;

import java.util.List;
import java.util.UUID;

/**
 * Application User Service Interface Class
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
public interface ApplicationUserService {

  /**
   * Create a user instance in the database
   *
   * @param applicationUser user type to be created. Please, see the {@link ApplicationUser} class for details.
   * @return ApplicationUser which is created. Please, see the {@link ApplicationUser} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  ApplicationUser createUser(ApplicationUser applicationUser);

  /**
   * Return all user instances in the database
   *
   * @return List<ApplicationUser>. Please, see the {@link ApplicationUser} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  List<ApplicationUser> getUsers();

  /**
   * Return a user instance by using its id in the database
   *
   * @param id user id to be filtered
   * @return ApplicationUser. Please, see the {@link ApplicationUser} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  ApplicationUser getUserById(UUID id);

  /**
   * Return a user instance by using its id in the database
   *
   * @param email user email to be filtered
   * @return ApplicationUser. Please, see the {@link ApplicationUser} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  ApplicationUser getUserByEmail(String email);

  /**
   * Update a user instance in the database
   *
   * @param id user id to be updated.
   * @param applicationUser user instance to be updated. Please, see the {@link ApplicationUser} class for details.
   * @return ApplicationUser which is updated. Please, see the {@link ApplicationUser} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  ApplicationUser updateUser(UUID id, ApplicationUser applicationUser);

  /**
   * Update a user status instance in the database by user id
   *
   * @param id user id to be updated.
   * @param status status of the user to be updated.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  void updateUserStatusById(UUID id, boolean status);
}

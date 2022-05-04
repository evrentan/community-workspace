package evrentan.community.usermanager.service;

import evrentan.community.usermanager.dto.UserType;

import java.util.List;
import java.util.UUID;

/**
 * User Type Service Interface Class
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
public interface UserTypeService {

  /**
   * Create a user type instance in the database
   *
   * @param userType user type to be created. Please, see the {@link UserType} class for details.
   * @return UserType which is created. Please, see the {@link UserType} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  UserType createUserType(UserType userType);

  /**
   * Return all user type instances in the database
   *
   * @return List<UserType>. Please, see the {@link UserType} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  List<UserType> getUserTypes();

  /**
   * Return a user type instance by using its id in the database
   *
   * @param id user type id to be filtered
   * @return UserType. Please, see the {@link UserType} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  UserType getUserType(UUID id);

  /**
   * Update a user type instance in the database
   *
   * @param id user type id to be updated.
   * @param userType user type instance to be updated. Please, see the {@link UserType} class for details.
   * @return UserType which is updated. Please, see the {@link UserType} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  UserType updateUserType(UUID id, UserType userType);

  /**
   * Update a user type status instance in the database
   *
   * @param id user type id to be updated.
   * @param status status of the user type to be updated.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  void updateUserTypeStatus(UUID id, boolean status);
}

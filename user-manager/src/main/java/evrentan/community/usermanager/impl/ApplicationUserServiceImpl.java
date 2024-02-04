package evrentan.community.usermanager.impl;

import evrentan.community.usermanager.dto.entity.ApplicationUser;
import evrentan.community.usermanager.entity.ApplicationUserEntity;
import evrentan.community.usermanager.exception.IdNotMatchException;
import evrentan.community.usermanager.exception.UserNotFoundException;
import evrentan.community.usermanager.mapper.ApplicationUserMapper;
import evrentan.community.usermanager.message.ExceptionMessages;
import evrentan.community.usermanager.repository.ApplicationUserRepository;
import evrentan.community.usermanager.service.ApplicationUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;


/**
 * Application User Service Implementation for Application User Service Layer.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

  private final ApplicationUserRepository applicationUserRepository;

  public ApplicationUserServiceImpl(ApplicationUserRepository applicationUserRepository) {
    this.applicationUserRepository = applicationUserRepository;
  }

  /**
   * Create a user instance in the database
   *
   * @param applicationUser user type to be created. Please, see the {@link ApplicationUser} class for details.
   * @return ApplicationUser which is created. Please, see the {@link ApplicationUser} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public ApplicationUser createUser(ApplicationUser applicationUser) {
    if (this.applicationUserRepository.existsDistinctByEmail(applicationUser.getEmail()))
      throw new IllegalArgumentException(USER_ALREADY_EXIST);

    return ApplicationUserMapper.toDto(this.applicationUserRepository.save(ApplicationUserMapper.toEntity(applicationUser)));
  }

  /**
   * Return all user instances in the database
   *
   * @return List<ApplicationUser>. Please, see the {@link ApplicationUser} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public List<ApplicationUser> getUsers() {
    List<ApplicationUser> applicationUserList = ApplicationUserMapper.toDtoList(this.applicationUserRepository.findAll());

    if (applicationUserList.isEmpty())
      throw new UserNotFoundException(ExceptionMessages.USER_NOT_FOUND);

    return applicationUserList;
  }

  /**
   * Return a user instance by using its id in the database
   *
   * @param id user id to be filtered
   * @return ApplicationUser. Please, see the {@link ApplicationUser} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public ApplicationUser getUserById(UUID id) {
    return ApplicationUserMapper.toDto(this.applicationUserRepository.findById(id).orElseThrow(() -> new UserNotFoundException(ExceptionMessages.USER_NOT_FOUND)));
  }

  /**
   * Return a user instance by using its id in the database
   *
   * @param email user email to be filtered
   * @return ApplicationUser. Please, see the {@link ApplicationUser} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public ApplicationUser getUserByEmail(String email) {
    return ApplicationUserMapper.toDto(this.applicationUserRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(ExceptionMessages.USER_NOT_FOUND)));
  }

  /**
   * Update a user instance in the database
   *
   * @param id user id to be updated.
   * @param applicationUser user type instance to be updated. Please, see the {@link ApplicationUser} class for details.
   * @return ApplicationUser which is updated. Please, see the {@link ApplicationUser} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public ApplicationUser updateUser(UUID id, ApplicationUser applicationUser) {
    if (!Objects.equals(id, applicationUser.getId()))
      throw new IdNotMatchException(ExceptionMessages.ID_NOT_MATCH);

    if (!this.applicationUserRepository.existsById(id))
      throw new UserNotFoundException(ExceptionMessages.USER_NOT_FOUND);

    return ApplicationUserMapper.toDto(this.applicationUserRepository.save(ApplicationUserMapper.toEntity(applicationUser)));
  }

  /**
   * Update a user status instance in the database
   *
   * @param id user id to be updated.
   * @param status status of the user type to be updated.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public void updateUserStatusById(UUID id, boolean status) {
    ApplicationUserEntity applicationUserEntity = this.applicationUserRepository.findById(id).orElseThrow(() -> new UserNotFoundException(ExceptionMessages.USER_NOT_FOUND));
    applicationUserEntity.setActive(status);
    this.applicationUserRepository.save(applicationUserEntity);
  }
}

package evrentan.community.usermanager.impl;

import evrentan.community.usermanager.dto.entity.UserType;
import evrentan.community.usermanager.entity.UserTypeEntity;
import evrentan.community.usermanager.exception.UserTypeAlreadyExistsException;
import evrentan.community.usermanager.exception.UserTypeNotFoundException;
import evrentan.community.usermanager.mapper.UserTypeMapper;
import evrentan.community.usermanager.message.ExceptionMessages;
import evrentan.community.usermanager.repository.UserTypeRepository;
import evrentan.community.usermanager.service.UserTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


/**
 * User Type Service Implementation for User Type Service Layer.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Service
public class UserTypeServiceImpl implements UserTypeService {

  private final UserTypeRepository userTypeRepository;

  public UserTypeServiceImpl(UserTypeRepository userTypeRepository) {
    this.userTypeRepository = userTypeRepository;
  }

  /**
   * Create a user type instance in the database
   *
   * @param userType user type to be created. Please, see the {@link UserType} class for details.
   * @return UserType which is created. Please, see the {@link UserType} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public UserType createUserType(UserType userType) {
    if (this.userTypeRepository.existsDistinctByCode(userType.getCode()))
      throw new UserTypeAlreadyExistsException(ExceptionMessages.USER_TYPE_ALREADY_EXIST);

    return UserTypeMapper.toDto(this.userTypeRepository.save(UserTypeMapper.toEntity(userType)));
  }

  /**
   * Return all user type instances in the database
   *
   * @return List<UserType>. Please, see the {@link UserType} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public List<UserType> getUserTypes() {
    List<UserType> userTypeList = UserTypeMapper.toDtoList(this.userTypeRepository.findAll());

    if (userTypeList.isEmpty())
      throw new UserTypeNotFoundException(ExceptionMessages.USER_TYPE_NOT_FOUND);

    return userTypeList;
  }

  /**
   * Return a user type instance by using its id in the database
   *
   * @param id user type id to be filtered
   * @return UserType. Please, see the {@link UserType} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public UserType getUserType(UUID id) {
    return UserTypeMapper.toDto(this.userTypeRepository.findById(id).orElseThrow(() -> new UserTypeNotFoundException(ExceptionMessages.USER_TYPE_NOT_FOUND)));
  }

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
  @Override
  public UserType updateUserType(UUID id, UserType userType) {
    if (!Objects.equals(id, userType.getId()))
      throw new UserTypeNotFoundException(ExceptionMessages.ID_NOT_MATCH);

    if (!this.userTypeRepository.existsById(id))
      throw new UserTypeNotFoundException(ExceptionMessages.USER_TYPE_NOT_FOUND);

    return UserTypeMapper.toDto(this.userTypeRepository.save(UserTypeMapper.toEntity(userType)));
  }

  /**
   * Update a user type status instance in the database
   *
   * @param id user type id to be updated.
   * @param status status of the user type to be updated.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public void updateUserTypeStatus(UUID id, boolean status) {
    UserTypeEntity userTypeEntity = this.userTypeRepository.findById(id).orElseThrow(() -> new UserTypeNotFoundException(ExceptionMessages.USER_TYPE_NOT_FOUND));
    userTypeEntity.setActive(status);
    this.userTypeRepository.save(userTypeEntity);
  }
}

package evrentan.community.usermanager.mapper;

import evrentan.community.usermanager.dto.UserType;
import evrentan.community.usermanager.entity.UserTypeEntity;

import java.util.List;
import java.util.Objects;

/**
 * User Type Mapper Class which maps UserTypeEntity to UserType and vice versa.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
public class UserTypeMapper {

  private UserTypeMapper() {
    throw new IllegalStateException(String.format("%s is a utility class", this.getClass().getCanonicalName()));
  }

  /**
   * Maps UserType to UserTypeEntity.
   * @param userType Entity to be mapped. Please, see the {@link UserType} class for details.
   * @return UserTypeEntity. Please, see the {@link UserTypeEntity} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static UserTypeEntity toEntity(UserType userType) {
    if (Objects.isNull(userType))
      return null;

    return UserTypeEntity.builder()
        .id(userType.getId())
        .code(userType.getCode())
        .description(userType.getDescription())
        .isActive(userType.isActive())
        .build();
  }

  /**
   * Maps UserTypeEntity to UserType.
   * @param userTypeEntity Entity to be mapped. Please, see the {@link UserTypeEntity} class for details.
   * @return UserType. Please, see the {@link UserType} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static UserType toDto(UserTypeEntity userTypeEntity) {
    if (Objects.isNull(userTypeEntity))
      return null;

    return UserType.builder()
        .id(userTypeEntity.getId())
        .code(userTypeEntity.getCode())
        .description(userTypeEntity.getDescription())
        .isActive(userTypeEntity.isActive())
        .build();
  }

  /**
   * Maps List of UserType to List of UserTypeEntity.
   *
   * @param userTypeList List of entities to be mapped. Please, see the {@link UserType} class for details.
   * @return List of UserTypeEntity. Please, see the {@link UserTypeEntity} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static List<UserTypeEntity> toEntityList(List<UserType> userTypeList) {
    return userTypeList.stream().parallel()
        .map(UserTypeMapper::toEntity)
        .collect(java.util.stream.Collectors.toList());
  }

  /**
   * Maps List of UserTypeEntity to List of UserType.
   *
   * @param userTypeEntityList List of entities to be mapped. Please, see the {@link UserTypeEntity} class for details.
   * @return List of UserType. Please, see the {@link UserType} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static List<UserType> toDtoList(List<UserTypeEntity> userTypeEntityList) {
    return userTypeEntityList.stream().parallel()
        .map(UserTypeMapper::toDto)
        .collect(java.util.stream.Collectors.toList());
  }
}

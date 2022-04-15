package evrentan.community.usermanager.mapper;

import evrentan.community.usermanager.dto.ApplicationUser;
import evrentan.community.usermanager.entity.ApplicationUserEntity;

import java.util.List;
import java.util.Objects;

/**
 * Application User Mapper Class which maps ApplicationUserEntity to ApplicationUser and vice versa.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
public class ApplicationUserMapper {

  private ApplicationUserMapper() {
    throw new IllegalStateException(String.format("%s is a utility class", this.getClass().getCanonicalName()));
  }

  /**
   * Maps ApplicationUser to ApplicationUserEntity.
   * @param applicationUser Entity to be mapped. Please, see the {@link ApplicationUser} class for details.
   * @return ApplicationUserEntity. Please, see the {@link ApplicationUserEntity} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static ApplicationUserEntity toEntity(ApplicationUser applicationUser) {
    if(Objects.isNull(applicationUser))
      return null;

    return ApplicationUserEntity.builder()
        .id(applicationUser.getId())
        .fullName(applicationUser.getFullName())
        .email(applicationUser.getEmail())
        .twitterAccount(applicationUser.getTwitterAccount())
        .linkedInAccount(applicationUser.getLinkedInAccount())
        .githubAccount(applicationUser.getGithubAccount())
        .websiteUrl(applicationUser.getWebsiteUrl())
        .userType(applicationUser.getUserType())
        .isActive(applicationUser.isActive())
        .build();
  }

  /**
   * Maps ApplicationUserEntity to ApplicationUser.
   * @param applicationUserEntity Entity to be mapped. Please, see the {@link ApplicationUserEntity} class for details.
   * @return ApplicationUser. Please, see the {@link ApplicationUser} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static ApplicationUser toDto(ApplicationUserEntity applicationUserEntity) {
    if(Objects.isNull(applicationUserEntity))
      return null;

    return ApplicationUser.builder()
        .id(applicationUserEntity.getId())
        .fullName(applicationUserEntity.getFullName())
        .email(applicationUserEntity.getEmail())
        .twitterAccount(applicationUserEntity.getTwitterAccount())
        .linkedInAccount(applicationUserEntity.getLinkedInAccount())
        .githubAccount(applicationUserEntity.getGithubAccount())
        .websiteUrl(applicationUserEntity.getWebsiteUrl())
        .userType(applicationUserEntity.getUserType())
        .isActive(applicationUserEntity.isActive())
        .build();
  }

  /**
   * Maps List of ApplicationUser to List of ApplicationUserEntity.
   *
   * @param applicationUserList List of entities to be mapped. Please, see the {@link ApplicationUser} class for details.
   * @return List of ApplicationUserEntity. Please, see the {@link ApplicationUserEntity} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static List<ApplicationUserEntity> toEntityList(List<ApplicationUser> applicationUserList) {
    return applicationUserList.stream().parallel()
        .map(ApplicationUserMapper::toEntity)
        .toList();
  }

  /**
   * Maps List of ApplicationUserEntity to List of ApplicationUser.
   *
   * @param applicationUserEntityList List of entities to be mapped. Please, see the {@link ApplicationUserEntity} class for details.
   * @return List of ApplicationUser. Please, see the {@link ApplicationUser} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static List<ApplicationUser> toDtoList(List<ApplicationUserEntity> applicationUserEntityList) {
    return applicationUserEntityList.stream().parallel()
        .map(ApplicationUserMapper::toDto)
        .toList();
  }
}

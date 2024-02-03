package evrentan.community.communitymanager.mapper;

import evrentan.community.communitymanager.dto.entity.Community;
import evrentan.community.communitymanager.entity.CommunityEntity;

import java.util.List;
import java.util.Objects;

/**
 * Community Mapper Class which maps CommunityEntity to Community and vice versa.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
public class CommunityMapper {

  private CommunityMapper() {
    throw new IllegalStateException(String.format("%s is a utility class", this.getClass().getCanonicalName()));
  }

  /**
   * Maps Community to CommunityEntity.
   * @param community Entity to be mapped. Please, see the {@link Community} class for details.
   * @return CommunityEntity. Please, see the {@link CommunityEntity} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static CommunityEntity toEntity(Community community) {
    if(Objects.isNull(community))
      return null;

    return CommunityEntity.builder()
        .id(community.getId())
        .name(community.getName())
        .description(community.getDescription())
        .active(community.isActive())
        .build();
  }

  /**
   * Maps CommunityEntity to Community.
   * @param communityEntity Entity to be mapped. Please, see the {@link CommunityEntity} class for details.
   * @return Community. Please, see the {@link Community} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static Community toDto(CommunityEntity communityEntity) {
    if(Objects.isNull(communityEntity))
      return null;

    return Community.builder()
        .id(communityEntity.getId())
        .name(communityEntity.getName())
        .description(communityEntity.getDescription())
        .active(communityEntity.isActive())
        .build();
  }

  /**
   * Maps List of Community to List of CommunityEntity.
   *
   * @param communityList List of entities to be mapped. Please, see the {@link Community} class for details.
   * @return List of CommunityEntity. Please, see the {@link CommunityEntity} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static List<CommunityEntity> toEntityList(List<Community> communityList) {
    return communityList.stream().parallel()
        .map(CommunityMapper::toEntity)
        .toList();
  }

  /**
   * Maps List of CommunityEntity to List of Community.
   *
   * @param communityEntityList List of entities to be mapped. Please, see the {@link CommunityEntity} class for details.
   * @return List of Community. Please, see the {@link Community} class for details.
   *
   *  @author <a href="https://github.com/evrentan">Evren Tan</a>
   *  @since 1.0.0
   */
  public static List<Community> toDtoList(List<CommunityEntity> communityEntityList) {
    return communityEntityList.stream().parallel()
        .map(CommunityMapper::toDto)
        .toList();
  }
}
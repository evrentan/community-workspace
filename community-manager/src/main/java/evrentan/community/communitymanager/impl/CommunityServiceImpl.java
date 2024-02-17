package evrentan.community.communitymanager.impl;

import evrentan.community.communitymanager.dto.entity.Community;
import evrentan.community.communitymanager.exception.CommunityNotFoundException;
import evrentan.community.communitymanager.entity.CommunityEntity;
import evrentan.community.communitymanager.mapper.CommunityMapper;
import evrentan.community.communitymanager.message.ExceptionMessages;
import evrentan.community.communitymanager.repository.CommunityRepository;
import evrentan.community.communitymanager.service.CommunityService;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * Community Service Implementation for Community Service Layer.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Service
public class CommunityServiceImpl implements CommunityService {

  private final CommunityRepository communityRepository;

  public CommunityServiceImpl(CommunityRepository communityRepository) {
    this.communityRepository = communityRepository;
  }

  /**
   * Create a community instance in the database
   *
   * @param community community to be created. Please, see the {@link Community} class for details.
   * @return Community which is created. Please, see the {@link Community} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public Community createCommunity(Community community) {
    return CommunityMapper.toDto(this.communityRepository.save(CommunityMapper.toEntity(community)));
  }

  /**
   * Return all community instances in the database
   *
   * @return List<Community>. Please, see the {@link Community} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public List<Community> getCommunities() {
    List<Community> communityList = CommunityMapper.toDtoList(this.communityRepository.findAll());

    if (communityList.isEmpty())
      throw new CommunityNotFoundException(ExceptionMessages.COMMUNITY_NOT_FOUND);

    return communityList;
  }

  /**
   * Return a community instance by using its id in the database
   *
   * @param id community id to be filtered
   * @return Community. Please, see the {@link Community} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public Community getCommunity(UUID id) {
    return CommunityMapper.toDto(this.communityRepository.findById(id).orElseThrow(() -> new CommunityNotFoundException(ExceptionMessages.COMMUNITY_NOT_FOUND)));
  }

  /**
   * Return true if community is active, otherwise false.
   *
   * @param id is the community id that is going to be retrieved.
   * @return Boolean. true if Community is active, otherwise false
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  public Boolean checkCommunityStatusById(UUID id) {
    final Community community = CommunityMapper.toDto(this.communityRepository.findById(id).orElse(null));

    return Objects.nonNull(community) && community.isActive();
  }

  /**
   * Update a community instance in the database
   *
   * @param id community id to be updated.
   * @param community community instance to be updated. Please, see the {@link Community} class for details.
   * @return Community which is updated. Please, see the {@link Community} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public Community updateCommunity(UUID id, Community community) {
    if (Objects.isNull(id) || Objects.isNull(community.getId()) || Objects.equals(id,community.getId()))
      throw  new BadRequestException("Bad Request");

    Optional<CommunityEntity> existCommunity = this.communityRepository.findById(id);
    if (existCommunity.isEmpty())
      throw new CommunityNotFoundException("Community Not Found");

    final Community updateCommunity = this.save(community);

    if (Objects.isNull(updateCommunity))
      throw new InternalServerErrorException("Community Not Updated");

    return updateCommunity;
  }

  /**
   * Update a community status instance in the database
   *
   * @param id community id to be updated.
   * @param status status of the community to be updated.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public Community updateCommunityStatus(UUID id, boolean status) {
    CommunityEntity communityEntity = this.communityRepository.findById(id).orElseThrow(() -> new CommunityNotFoundException(ExceptionMessages.COMMUNITY_NOT_FOUND));
    communityEntity.setActive(status);

    return CommunityMapper.toDto(this.communityRepository.save(communityEntity));
  }

  private Community save(Community community){
    CommunityEntity communityEntity = CommunityMapper.toEntity(community);
    communityEntity = this.communityRepository.save(communityEntity);
    return CommunityMapper.toDto(communityEntity);
  }
}
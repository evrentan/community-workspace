package evrentan.community.communitymanager.impl;

import evrentan.community.communitymanager.dto.Community;
import evrentan.community.communitymanager.entity.CommunityEntity;
import evrentan.community.communitymanager.mapper.CommunityMapper;
import evrentan.community.communitymanager.repository.CommunityRepository;
import evrentan.community.communitymanager.service.CommunityInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

/**
 * Community Service Implementation for Community Service Layer.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Service
public class CommunityService implements CommunityInterface {

  private final CommunityRepository communityRepository;

  public CommunityService(CommunityRepository communityRepository) {
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
    return CommunityMapper.toDtoList(this.communityRepository.findAll());
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
    return CommunityMapper.toDto(this.communityRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Community not found")));
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
    if(!Objects.equals(id, community.getId()))
      throw new IllegalArgumentException("Ids do not match");

    if (!this.communityRepository.existsById(id))
      throw new NoSuchElementException("Community not found");

    return CommunityMapper.toDto(this.communityRepository.save(CommunityMapper.toEntity(community)));
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
    CommunityEntity communityEntity = this.communityRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Community not found"));
    communityEntity.setActive(status);

    return CommunityMapper.toDto(this.communityRepository.save(communityEntity));
  }
}
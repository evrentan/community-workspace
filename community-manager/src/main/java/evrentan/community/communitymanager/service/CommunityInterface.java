package evrentan.community.communitymanager.service;

import evrentan.community.communitymanager.dto.Community;

import java.util.List;
import java.util.UUID;

/**
 * Community Interface Class
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
public interface CommunityInterface {

  /**
   * Create a community instance in the database
   *
   * @param community community to be created. Please, see the {@link Community} class for details.
   * @return Community which is created. Please, see the {@link Community} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  Community createCommunity(Community community);

  /**
   * Return all community instances in the database
   *
   * @return List<Community>. Please, see the {@link Community} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  List<Community> getCommunities();

  /**
   * Return a community instance by using its id in the database
   *
   * @param id community id to be filtered
   * @return Community. Please, see the {@link Community} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  Community getCommunity(UUID id);

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
  Community updateCommunity(UUID id, Community community);

  /**
   * Update a community status instance in the database
   *
   * @param id community id to be updated.
   * @param status status of the community to be updated.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  Community updateCommunityStatus(UUID id, boolean status);
}
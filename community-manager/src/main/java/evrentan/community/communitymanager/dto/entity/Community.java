package evrentan.community.communitymanager.dto.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

/**
 * Community Class.
 * It is equalized to the {@link evrentan.community.communitymanager.entity.CommunityEntity} in entity level.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Getter @Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode @ToString
@Builder
@Schema(description = "Community Class")
public class Community {

  /**
   * Community ID in UUID Type.
   *
   * @since 1.0.0
   */
  @Schema(description = "Community ID in UUID Type")
  private UUID id;

  /**
   * Community Name in String Type
   *
   * @since 1.0.0
   */
  @Schema(description = "Community Name in String Type")
  private String name;

  /**
   * Community Description in String Type
   *
   * @since 1.0.0
   */
  @Schema(description = "Community Description in String Type")
  private String description;

  /**
   * Indicates if the community is active or not.
   *
   * @since 1.0.0
   */
  @Schema(description = "Indicates if the community is active or not.")
  @Builder.Default
  private boolean active = true;
}

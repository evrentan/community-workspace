package evrentan.community.venuemanager.dto.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

/**
 * Venue Class.
 * It is equalized to the {@link evrentan.community.venuemanager.entity.VenueEntity} in entity level.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Getter @Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode @ToString
@Builder
@Schema(description = "Venue Class")
public class Venue {

  /**
   * Venue ID in UUID Type.
   *
   * @since 1.0.0
   */
  @Schema(description = "Venue ID in UUID Type")
  private UUID id;

  /**
   * Venue Name in String Type
   *
   * @since 1.0.0
   */
  @Schema(description = "Venue Name in String Type")
  private String name;

  /**
   * Venue Description in String Type
   *
   * @since 1.0.0
   */
  @Schema(description = "Venue Description in String Type")
  private String description;

  /**
   * Venue City in String Type.
   *
   * @since 1.0.0
   */
  @Schema(description = "Venue City in String Type")
  private String city;

  /**
   * Venue Address in String Type.
   *
   * @since 1.0.0
   */
  @Schema(description = "Venue Address in String Type")
  private String address;

  /**
   * Indicates if the venue is active or not.
   *
   * @since 1.0.0
   */
  @Schema(description = "Indicates if the venue is active or not.")
  @Builder.Default
  private boolean active = true;
}

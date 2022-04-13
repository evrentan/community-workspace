package evrentan.community.venuemanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

/**
 * VenueRoom Class.
 * It is equalized to the {@link evrentan.community.venuemanager.entity.VenueRoomEntity} in entity level.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode @ToString
@Builder
@Schema(description = "Venue - Room Association Class")
public class VenueRoom {

  /**
   * VenueRoom ID in UUID Type.
   *
   * @since 1.0.0
   */
  @Schema(description = "VenueRoom ID in UUID Type")
  private UUID id;

  /**
   * Venue ID in UUID Type.
   *
   * @since 1.0.0
   */
  @Schema(description = "Venue ID in UUID Type")
  private UUID venueId;

  /**
   * Room ID in UUID Type.
   *
   * @since 1.0.0
   */
  @Schema(description = "Room ID in UUID Type")
  private UUID roomId;

  /**
   * Indicates whether the venue room association is active or not.
   *
   * @since 1.0.0
   */
  @Schema(description = "Indicates whether the venue room association is active or not")
  private boolean active;
}
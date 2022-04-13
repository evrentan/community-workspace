package evrentan.community.venuemanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

/**
 * Room Class.
 * It is equalized to the {@link evrentan.community.venuemanager.entity.RoomEntity} in entity level.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Getter @Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode @ToString
@Builder
@Schema(description = "Room Class")
public class Room {

  /**
   * Room ID in UUID Type.
   *
   * @since 1.0.0
   */
  @Schema(description = "Room ID in UUID Type")
  private UUID id;

  /**
   * Room Name in String Type
   *
   * @since 1.0.0
   */
  @Schema(description = "Room Name in String Type")
  private String name;

  /**
   * Room Description in String Type
   *
   * @since 1.0.0
   */
  @Schema(description = "Room Description in String Type")
  private String description;

  /**
   * Room Capacity in Integer Type.
   *
   * @since 1.0.0
   */
  @Schema(description = "Room Capacity in Integer Type")
  private Integer capacity;

  /**
   * Indicates if the venue is active or not.
   *
   * @since 1.0.0
   */
  @Schema(description = "Indicates if the venue is active or not.")
  @Builder.Default
  private boolean active = true;
}

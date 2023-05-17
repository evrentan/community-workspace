package evrentan.community.eventmanager.dto.entity;

import evrentan.community.eventmanager.entity.EventRoomEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;
/**
 * Community Class.
 * It is equalized to the {@link EventRoomEntity} in entity level.
 *
 * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
 * @since 1.0.0
 */

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Schema(description = "Event Room Class")
public class EventRoom {

    /**
     * EventRoom ID in UUID Type.
     *
     * @since 1.0.0
     */
    @Schema(description = "EventRoom ID in UUID Type")
    private UUID id;


    @Schema
    private UUID roomId;

    /**
     * Indicates if the event room is active or not.
     *
     * @since 1.0.0
     */
    @Schema
    private boolean isActive;
}

package evrentan.community.eventmanager.dto;

import evrentan.community.eventmanager.entity.EventRoom;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;
/**
 * Community Class.
 * It is equalized to the {@link EventRoom} in entity level.
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
public class EventRoomDto {

    @Schema()
    private UUID id;

    @Schema
    private UUID roomId;

    @Schema
    private boolean isActive;
}

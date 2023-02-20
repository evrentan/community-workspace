package evrentan.community.eventmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

/**
 * EventCommunityDto Class.
 * It is equalized to the {@link evrentan.community.eventmanager.entity.EventCommunity} in entity level.
 *
 * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
 * @since 1.0.0
 */
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@Schema(description = "Event Community Class")
public class EventCommunityDto {

    /**
     * Event ID in UUID Type.
     *
     * @since 1.0.0
     */
    @Schema(description = "Event Community ID in UUID Type")
    private UUID id;

    /**
     * Community ID in UUID Type.
     *
     * @since 1.0.0
     */
    @Schema(description = "Community ID in UUID Type")
    private UUID communityId;

    /**
     * Indicates if the event community is active or not.
     *
     * @since 1.0.0
     */
    @Schema(description = "Indicates if the community is active or not.")
    private boolean isActive;
}

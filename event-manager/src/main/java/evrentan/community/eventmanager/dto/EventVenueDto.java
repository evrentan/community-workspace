package evrentan.community.eventmanager.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

/**
 * EventParticipantDto Class.
 * It is equalized to the {@link evrentan.community.eventmanager.entity.EventVenue} in entity level.
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
@Schema(description = "Event Venue Class")
public class EventVenueDto {

    /**
     * Event Venue ID in UUID Type.
     *
     * @since 1.0.0
     */
    @Schema(description = "Event Venue ID in UUID Type")
    private UUID id;

    /**
     * Indicates if the event venue is active or not.
     *
     * @since 1.0.0
     */
    @Schema(description = "Indicates if the event venue is active or not")
    private boolean isActive;
}

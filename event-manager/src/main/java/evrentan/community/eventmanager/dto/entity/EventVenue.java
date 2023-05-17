package evrentan.community.eventmanager.dto.entity;


import evrentan.community.eventmanager.entity.EventVenueEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

/**
 * EventParticipant Class.
 * It is equalized to the {@link EventVenueEntity} in entity level.
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
@Schema(description = "EventVenue Class")
public class EventVenue {

    /**
     * EventVenue ID in UUID Type.
     *
     * @since 1.0.0
     */
    @Schema(description = "EventVenue ID in UUID Type")
    private UUID id;

    /**
     * Indicates if the event venue is active or not.
     *
     * @since 1.0.0
     */
    @Schema(description = "Indicates if the event venue is active or not")
    private boolean isActive;
}

package evrentan.community.eventmanager.dto.entity;


import evrentan.community.eventmanager.entity.EventParticipantEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

/**
 * EventParticipant Class.
 * It is equalized to the {@link EventParticipantEntity} in entity level.
 *
 * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
 * @since 1.0.0
 */

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode @ToString
@Builder
@Schema(description = "Event Participant Class")
public class EventParticipant {

    /**
     * EventParticipant ID in UUID Type.
     *
     * @since 1.0.0
     */
    @Schema(description = "EventParticipant ID in UUID Type")
    private UUID id;

    /**
     * Indicates if the event participant is active or not.
     *
     * @since 1.0.0
     */
    @Schema(description = "Indicates if the participant is active or not.")
    private boolean isActive;


}

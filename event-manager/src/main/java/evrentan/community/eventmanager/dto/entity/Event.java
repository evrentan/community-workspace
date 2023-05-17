package evrentan.community.eventmanager.dto.entity;

import evrentan.community.eventmanager.entity.EventEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Event Class.
 * It is equalized to the {@link EventEntity} in entity level.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode @ToString
@Builder
@Schema(description = "Event Class")
public class Event {

    /**
     * Event ID in UUID Type.
     *
     * @since 1.0.0
     */
    @Schema(description = "Event ID in UUID Type")
    private UUID id;

    /**
     * EventEntity Name in String Type
     *
     * @since 1.0.0
     */
    @Schema(description = "EventEntity Name is String Type")
    private String name;

    /**
     * EventEntity Description in String Type
     *
     * @since 1.0.0
     */
    @Schema(description = "EventEntity Description in String Type ")
    private String  description;

    /**
     * Indicates if the event is active or not.
     *
     * @since 1.0.0
     */
    @Schema(description = "Indicates if the event is active or not." )
    private boolean isActive;

    /**
     * EventEntity Date in LocalDateTime Type
     *
     * @since 1.0.0
     */
    @Schema(description = "EventEntity Date is LocalDateTime Type")
    private LocalDateTime eventDate;

    /**
     * Indicates if the event is online or not.
     *
     * @since 1.0.0
     */
    @Schema(description = "Indicates if the event is online or not.")
    private boolean isOnline;

    /**
     * Event URL in String Type
     *
     * @since 1.0.0
     */
    @Schema(description = "Event URL in String Type")
    private String url;

    /**
     * Indicates if the event is Free or not.
     *
     * @since 1.0.0
     */
    @Schema(description = "Indicates if the event is free or not.")
    private boolean isFree;

    /**
     * Event Fee in Double Type
     *
     * @since 1.0.0
     */
    @Schema(description = "Event Fee in Double Type")
    private Double eventFee;

    /**
     * Event Fee Currency in String Type
     *
     * @since 1.0.0
     */
    @Schema(description = "Event Fee Currency in String Type")
    private String eventFeeCurrency;

    /**
     * Event Participant Limit in Integer Type
     *
     * @since 1.0.0
     */
    @Schema(description = "Event Participant Limit in Integer Type")
    private Integer participantLimit;
}


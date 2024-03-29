package evrentan.community.eventmanager.dto.request;

import evrentan.community.eventmanager.controller.EventController;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * CreateEventRequest Class.
 * It is used to create event via the {@link EventController#createEvent(CreateEventRequest) CreateEvent}  in entity level.
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
@Schema(description = "Create Event Request Class")
public class CreateEventRequest {

    /**
     * Event ID in UUID Type.
     *
     * @since 1.0.0
     */
    @Schema(description = "Event ID in UUID Type")
    private UUID id;

    /**
     * Event Name in String Type
     *
     * @since 1.0.0
     */
    @Schema(description = "Event Name is String Type")
    private String name;

    /**
     * Event Description in String Type
     *
     * @since 1.0.0
     */
    @Schema(description = "Event Description in String Type ")
    private String  description;

    /**
     * Indicates if the event is active or not.
     *
     * @since 1.0.0
     */
    @Schema(description = "Indicates if the event is active or not." )
    private boolean isActive;

    /**
     * Community ID whose Organizing the Event in UUID Type
     *
     * @since 1.0.0
     */
    @Schema(description = "Community ID whose Organizing the Event in UUID")
    private UUID communityId;

    /**
     * Event Date in LocalDateTime Type
     *
     * @since 1.0.0
     */
    @Schema(description = "Event Date is LocalDateTime Type")
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
     * Venue ID where the Event will be held in UUID Type
     *
     * @since 1.0.0
     */
    @Schema(description = "Venue ID where the Event will be held in UUID Type")
    private UUID venueId;

    /**
     * Room ID where the Event will be held in UUID Type
     *
     * @since 1.0.0
     */
    @Schema(description = "Room ID where the Event will be held in UUID Type")
    private UUID roomId;

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


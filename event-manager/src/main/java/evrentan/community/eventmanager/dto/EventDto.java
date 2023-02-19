package evrentan.community.eventmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * EventDto Class.
 * It is equalized to the {@link evrentan.community.eventmanager.entity.EventEntity} in entity level.
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
public class EventDto {

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
    //@Builder.Default
    private boolean isActive;

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
    //@Builder.Default
    private boolean isOnline;

    /**
     * Event URL in String Type
     *
     * @since 1.0.0
     */
    @Schema(description = "Event URL in String Type")
    private String url;

    @Schema(description = "Indicates if the event is free or not.")
    //@Builder.Default
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


package evrentan.community.eventmanager.dto.response;

import evrentan.community.eventmanager.controller.EventController;
import evrentan.community.eventmanager.dto.request.CreateEventRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

/**
 * CreateEventRequest Class.
 * It is used to for the response of create event via the {@link EventController#createEvent(CreateEventRequest) CreateEvent}  in entity level.
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
@Schema(description = "Create EventEntity Response Class")
public class CreateEventResponse {


    /**
     * Event ID in UUID Type.
     *
     * @since 1.0.0
     */
    @Schema(description = "Event ID in UUID Type")
    private UUID id;
}

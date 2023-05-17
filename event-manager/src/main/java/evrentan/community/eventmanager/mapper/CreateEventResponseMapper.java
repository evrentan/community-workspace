package evrentan.community.eventmanager.mapper;

import evrentan.community.eventmanager.dto.response.CreateEventResponse;
import evrentan.community.eventmanager.dto.entity.Event;

import java.util.Objects;

/**
 * CreateEventResponse Mapper Class.
 *
 * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
 * @since 1.0.0
 */
public class CreateEventResponseMapper {

    /**
     * Maps Event to CreateEventResponse
     * @param event Dto to be mapped. Please, see the {@link Event} class for details.
     * @return CreateEventResponse. Please, see the {@link CreateEventResponse} class for details.
     *
     *  @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     *  @since 1.0.0
     */
    public static CreateEventResponse toDtoFromEvent(Event event) {
        if (Objects.isNull(event))
            return null;

        return CreateEventResponse.builder()
                .id(event.getId())
                .build();
    }
}

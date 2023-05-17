package evrentan.community.eventmanager.mapper;

import evrentan.community.eventmanager.dto.request.CreateEventRequest;
import evrentan.community.eventmanager.entity.EventRoomEntity;

import java.util.List;
import java.util.Objects;

/**
 * EventRoom Class which maps EventRoomEntity to EventRoom and vice versa.
 *
 * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
 * @since 1.0.0
 */
public class EventRoomMapper {

    /**
     * Maps CreateEventRequest to EventRoomEntity
     * @param createEventRequest Entity to be mapped. Please, see the {@link CreateEventRequest} class for details.
     * @return EventRoomEntity. Please, see the {@link EventRoomEntity} class for details.
     *
     *  @author <a href="https://github.com/evrentan">Evren Tan</a>
     *  @since 1.0.0
     */
    public static EventRoomEntity toEntityFromCreateEventDto(CreateEventRequest createEventRequest) {
        if (Objects.isNull(createEventRequest))
            return null;

        return EventRoomEntity.builder()
                .id(createEventRequest.getId())
                .roomId(createEventRequest.getCommunityId())
                .isActive(createEventRequest.isActive())
                .build();
    }

    /**
     * Maps List of CreateEventRequest to List of EventRoomEntity.
     *
     * @param createEventRequestList List of entities to be mapped. Please, see the {@link CreateEventRequest} class for details.
     * @return List of EventRoomEntity. Please, see the {@link EventRoomEntity} class for details.
     *
     *  @author <a href="https://github.com/evrentan">Evren Tan</a>
     *  @since 1.0.0
     */
    public static List<EventRoomEntity> toEntityListFromCreateEventDtoList(List<CreateEventRequest> createEventRequestList) {
        return createEventRequestList.stream().parallel()
                .map(EventRoomMapper::toEntityFromCreateEventDto)
                .toList();
    }
}

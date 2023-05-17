package evrentan.community.eventmanager.mapper;

import evrentan.community.eventmanager.dto.request.CreateEventRequest;
import evrentan.community.eventmanager.entity.EventCommunityEntity;

import java.util.List;
import java.util.Objects;

/**
 * EventCommunity Mapper Class which maps EventCommunityEntity to EventCommunity and vice versa.
 *
 * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
 * @since 1.0.0
 */
public class EventCommunityMapper {

    /**
     * Maps CreateEventRequest to EventCommunityEntity
     * @param createEventRequest Entity to be mapped. Please, see the {@link CreateEventRequest} class for details.
     * @return EventCommunityEntity. Please, see the {@link EventCommunityEntity} class for details.
     *
     *  @author <a href="https://github.com/evrentan">Evren Tan</a>
     *  @since 1.0.0
     */
    public static EventCommunityEntity toEntityFromCreateEventDto(CreateEventRequest createEventRequest) {
        if (Objects.isNull(createEventRequest))
            return null;

        return EventCommunityEntity.builder()
                .id(createEventRequest.getId())
                .communityId(createEventRequest.getCommunityId())
                .isActive(createEventRequest.isActive())
                .build();
    }

    /**
     * Maps List of CreateEventRequest to List of EventCommunityEntity.
     *
     * @param createEventRequestList List of entities to be mapped. Please, see the {@link CreateEventRequest} class for details.
     * @return List of EventCommunityEntity. Please, see the {@link EventCommunityEntity} class for details.
     *
     *  @author <a href="https://github.com/evrentan">Evren Tan</a>
     *  @since 1.0.0
     */
    public static List<EventCommunityEntity> toEntityListFromCreateEventDtoList(List<CreateEventRequest> createEventRequestList) {
        return createEventRequestList.stream().parallel()
                .map(EventCommunityMapper::toEntityFromCreateEventDto)
                .toList();
    }
}

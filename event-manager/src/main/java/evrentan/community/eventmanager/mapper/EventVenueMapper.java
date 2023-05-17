package evrentan.community.eventmanager.mapper;

import evrentan.community.eventmanager.dto.request.CreateEventRequest;
import evrentan.community.eventmanager.entity.EventVenueEntity;

import java.util.List;
import java.util.Objects;

/**
 * EventVenue Mapper Class which maps EventVenueEntity to Event and vice versa.
 *
 * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
 * @since 1.0.0
 */
public class EventVenueMapper {

    /**
     * Maps CreateEventRequest to EventVenueEntity
     * @param createEventRequest Entity to be mapped. Please, see the {@link CreateEventRequest} class for details.
     * @return EventVenueEntity. Please, see the {@link EventVenueEntity} class for details.
     *
     *  @author <a href="https://github.com/evrentan">Evren Tan</a>
     *  @since 1.0.0
     */
    public static EventVenueEntity toEntityFromCreateEventDto(CreateEventRequest createEventRequest) {
        if (Objects.isNull(createEventRequest))
            return null;

        return EventVenueEntity.builder()
                .id(createEventRequest.getId())
                .venueId(createEventRequest.getCommunityId())
                .isActive(createEventRequest.isActive())
                .build();
    }

    /**
     * Maps List of CreateEventRequest to List of EventVenueEntity.
     *
     * @param createEventRequestList List of entities to be mapped. Please, see the {@link CreateEventRequest} class for details.
     * @return List of EventVenueEntity. Please, see the {@link EventVenueEntity} class for details.
     *
     *  @author <a href="https://github.com/evrentan">Evren Tan</a>
     *  @since 1.0.0
     */
    public static List<EventVenueEntity> toEntityListFromCreateEventDtoList(List<CreateEventRequest> createEventRequestList) {
        return createEventRequestList.stream().parallel()
                .map(EventVenueMapper::toEntityFromCreateEventDto)
                .toList();
    }
}

package evrentan.community.eventmanager.mapper;

import evrentan.community.eventmanager.dto.entity.Event;
import evrentan.community.eventmanager.dto.request.CreateEventRequest;
import evrentan.community.eventmanager.entity.EventEntity;

import java.util.List;
import java.util.Objects;

/**
 * EventEntity Mapper Class.
 *
 * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
 * @since 1.0.0
 */
public class EventMapper {

    /**
     * Maps Event to EventEntity
     * @param event Entity to be mapped. Please, see the {@link Event} class for details.
     * @return EventEntity. Please, see the {@link EventEntity} class for details.
     *
     *  @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     *  @since 1.0.0
     */
    public static EventEntity toEntity(Event event) {
        if (Objects.isNull(event))
            return null;

        return EventEntity.builder()
                .id(event.getId())
                .name(event.getName())
                .description(event.getDescription())
                .isActive(event.isActive())
                .eventDate(event.getEventDate())
                .isOnline(event.isOnline())
                .url(event.getUrl())
                .isFree(event.isFree())
                .eventFee(event.getEventFee())
                .eventFeeCurrency(event.getEventFeeCurrency())
                .participantLimit(event.getParticipantLimit())
                .build();
    }

    /**
     * Maps CommunityEntity to Community.
     * @param eventEntity Entity to be mapped. Please, see the {@link EventEntity} class for details.
     * @return Event. Please, see the {@link Event} class for details.
     *
     *  @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     *  @since 1.0.0
     */
    public static Event toDto(EventEntity eventEntity) {
        if (Objects.isNull(eventEntity))
            return null;

        return Event.builder()
                .id(eventEntity.getId())
                .name(eventEntity.getName())
                .description(eventEntity.getDescription())
                .isActive(eventEntity.isActive())
                .eventDate(eventEntity.getEventDate())
                .isOnline(eventEntity.isOnline())
                .url(eventEntity.getUrl())
                .isFree(eventEntity.isFree())
                .eventFee(eventEntity.getEventFee())
                .eventFeeCurrency(eventEntity.getEventFeeCurrency())
                .participantLimit(eventEntity.getParticipantLimit())
                .build();
    }

    /**
     * Maps List of Event to List of EventEntity.
     *
     * @param eventList List of entities to be mapped. Please, see the {@link Event} class for details.
     * @return List of EventEntity. Please, see the {@link EventEntity} class for details.
     *
     *  @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     *  @since 1.0.0
     */
    public static List<EventEntity> toEntityList(List<Event> eventList) {
        return eventList.stream().parallel()
                .map(EventMapper::toEntity)
                .toList();
    }


    /**
     * Maps List of EventEntity to List of Event.
     *
     * @param eventEntityList List of entities to be mapped. Please, see the {@link EventEntity} class for details.
     * @return List of Community. Please, see the {@link Event} class for details.
     *
     *  @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     *  @since 1.0.0
     */
    public static List<Event> toDtoList(List<EventEntity> eventEntityList){
        return eventEntityList.stream().parallel()
                .map(EventMapper::toDto)
                .toList();
    }

    /**
     * Maps CreateEventRequest to EventEntity
     * @param createEventRequest Entity to be mapped. Please, see the {@link CreateEventRequest} class for details.
     * @return EventEntity. Please, see the {@link EventEntity} class for details.
     *
     *  @author <a href="https://github.com/evrentan">Evren Tan</a>
     *  @since 1.0.0
     */
    public static EventEntity toEntityFromCreateEventDto(CreateEventRequest createEventRequest) {
        if (Objects.isNull(createEventRequest))
            return null;

        return EventEntity.builder()
                .id(createEventRequest.getId())
                .name(createEventRequest.getName())
                .description(createEventRequest.getDescription())
                .isActive(createEventRequest.isActive())
                .eventDate(createEventRequest.getEventDate())
                .isOnline(createEventRequest.isOnline())
                .url(createEventRequest.getUrl())
                .isFree(createEventRequest.isFree())
                .eventFee(createEventRequest.getEventFee())
                .eventFeeCurrency(createEventRequest.getEventFeeCurrency())
                .participantLimit(createEventRequest.getParticipantLimit())
                .build();
    }

    /**
     * Maps List of CreateEventRequest to List of EventEntity.
     *
     * @param createEventRequestList List of entities to be mapped. Please, see the {@link CreateEventRequest} class for details.
     * @return List of EventEntity. Please, see the {@link EventEntity} class for details.
     *
     *  @author <a href="https://github.com/evrentan">Evren Tan</a>
     *  @since 1.0.0
     */
    public static List<EventEntity> toEntityListFromCreateEventDtoList(List<CreateEventRequest> createEventRequestList) {
        return createEventRequestList.stream().parallel()
                .map(EventMapper::toEntityFromCreateEventDto)
                .toList();
    }
}

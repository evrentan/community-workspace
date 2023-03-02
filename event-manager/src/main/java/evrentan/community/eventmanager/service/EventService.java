package evrentan.community.eventmanager.service;

import evrentan.community.eventmanager.dto.EventDto;

import java.util.List;
import java.util.UUID;

/**
 * Event Service Interface Class
 *
 * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
 * @since 1.0.0
 */
public interface EventService {

    /**
     * Create an event instance in the database
     *
     * @param eventDto event to be created. Please, see the {@link EventDto} class for details.
     * @return EventDto which is created. Please, see the {@link EventDto} class for details.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    EventDto createEvent(EventDto eventDto);

    /**
     * Update an event status instance in the database
     *
     * @param id event id to be updated.
     * @param status status of the event to be updated.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    EventDto updateEventStatus(UUID id, boolean status);

    /**
     * Return all event instances in the database
     *
     * @return List<EventDto>. Please, see the {@link EventDto} class for details.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    List<EventDto> getAllEvents();

    /**
     * Return an event instance by using its id in the database
     *
     * @param id event id to be filtered
     * @return EventDto. Please, see the {@link EventDto} class for details.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    EventDto getEvent(UUID id);

    /**
     * Update an event instance in the database
     *
     * @param id event id to be updated.
     * @param eventDto event instance to be updated. Please, see the {@link EventDto} class for details.
     * @return EventDto which is updated. Please, see the {@link EventDto} class for details.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    EventDto updateEvent(UUID id, EventDto eventDto);
}

package evrentan.community.eventmanager.service;

import evrentan.community.eventmanager.dto.entity.Event;
import evrentan.community.eventmanager.dto.request.CreateEventRequest;
import evrentan.community.eventmanager.dto.response.CreateEventResponse;
import java.util.List;
import java.util.UUID;

/**
 * EventEntity Service Interface Class
 *
 * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
 * @since 1.0.0
 */
public interface EventService {

    /**
     * Create an event instance in the database
     *
     * @param createEventRequest event to be created. Please, see the {@link CreateEventRequest} class for details.
     * @return CreateEventResponse which corresponds to the event created. Please, see the {@link CreateEventResponse} class for details.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    CreateEventResponse createEvent(CreateEventRequest createEventRequest);

    /**
     * Update an event status instance in the database
     *
     * @param id event id to be updated.
     * @param status status of the event to be updated.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    Event updateEventStatus(UUID id, boolean status);

    /**
     * Return all event instances in the database
     *
     * @return List<Event>. Please, see the {@link Event} class for details.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    List<Event> getAllEvents();

    /**
     * Return an event instance by using its id in the database
     *
     * @param id event id to be filtered
     * @return Event. Please, see the {@link Event} class for details.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    Event getEvent(UUID id);

    /**
     * Update an event instance in the database
     *
     * @param id event id to be updated.
     * @param event event instance to be updated. Please, see the {@link Event} class for details.
     * @return Event which is updated. Please, see the {@link Event} class for details.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    Event updateEvent(UUID id, Event event);
}

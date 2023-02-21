package evrentan.community.eventmanager.service;

import evrentan.community.eventmanager.dto.EventDto;

/**
 * Event Service Interface Class
 *
 * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
 * @since 1.0.0
 */
public interface EventService {

    /**
     * Create a community instance in the database
     *
     * @param eventDto community to be created. Please, see the {@link EventDto} class for details.
     * @return Community which is created. Please, see the {@link EventDto} class for details.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    EventDto createEvent(EventDto eventDto);

}

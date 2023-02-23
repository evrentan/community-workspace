package evrentan.community.eventmanager.impl;

import evrentan.community.eventmanager.dto.EventDto;
import evrentan.community.eventmanager.entity.EventEntity;
import evrentan.community.eventmanager.mapper.EventMapper;
import evrentan.community.eventmanager.repository.EventRepository;
import evrentan.community.eventmanager.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Event Service Implementation for Event Service Layer.
 *
 * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
 * @since 1.0.0
 */
@Service
public class EventServiceImpl implements EventService {


    private final EventRepository eventRepository;

    public EventServiceImpl (EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    /**
     * Create an event instance in the database
     *
     * @param eventDto event to be created. Please, see the {@link EventDto} class for details.
     * @return EventDto which is created. Please, see the {@link EventDto} class for details.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    @Override
    public EventDto createEvent(EventDto eventDto) {
        return EventMapper.toDto(this.eventRepository.save(EventMapper.toEntity(eventDto)));
    }

    /**
     * Update an event status instance in the database
     *
     * @param id event id to be updated.
     * @param status status of the event to be updated.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    @Override
    public EventDto updateEventStatus(UUID id, boolean status) {
        EventEntity eventEntity = this.eventRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Event not found"));
        eventEntity.setActive(status);

        return EventMapper.toDto(this.eventRepository.save(eventEntity));
    }

    /**
     * Return all event instances in the database
     *
     * @return List<EventDto>. Please, see the {@link EventDto} class for details.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    @Override
    public List<EventDto> getAllEvents() {
        return EventMapper.toDtoList(this.eventRepository.findAll());
    }
}

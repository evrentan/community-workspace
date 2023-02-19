package evrentan.community.eventmanager.impl;

import evrentan.community.eventmanager.dto.EventDto;
import evrentan.community.eventmanager.mapper.EventMapper;
import evrentan.community.eventmanager.repository.EventRepository;
import evrentan.community.eventmanager.service.EventService;
import org.springframework.stereotype.Service;

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


    @Override
    public EventDto createEvent(EventDto eventDto) {
        return EventMapper.toDto(this.eventRepository.save(EventMapper.toEntity(eventDto)));
    }
}

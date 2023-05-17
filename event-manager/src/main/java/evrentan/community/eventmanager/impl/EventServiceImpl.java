package evrentan.community.eventmanager.impl;

import evrentan.community.eventmanager.dto.entity.Event;
import evrentan.community.eventmanager.dto.request.CreateEventRequest;
import evrentan.community.eventmanager.dto.response.CreateEventResponse;
import evrentan.community.eventmanager.entity.EventEntity;
import evrentan.community.eventmanager.mapper.CreateEventResponseMapper;
import evrentan.community.eventmanager.mapper.EventMapper;
import evrentan.community.eventmanager.repository.EventRepository;
import evrentan.community.eventmanager.service.EventService;
import evrentan.community.eventmanager.service.VenueService;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

/**
 * Event Service Implementation for Event Service Layer.
 *
 * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Service
public class EventServiceImpl implements EventService {

    private static final String VENUE_NOT_AVAILABLE = "Venue is not available !!!";
    private static final String ROOM_NOT_AVAILABLE = "Room is not available !!!";


    private final EventRepository eventRepository;
    private final VenueService venueService;

    public EventServiceImpl (EventRepository eventRepository, VenueService venueService){
        this.eventRepository = eventRepository;
        this.venueService = venueService;
    }

    /**
     * Create an event instance in the database
     *
     * @param createEventRequest event to be created. Please, see the {@link CreateEventRequest} class for details.
     * @return CreateEventResponse which event is created. Please, see the {@link CreateEventResponse} class for details.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    @Override
    public CreateEventResponse createEvent(CreateEventRequest createEventRequest) {

        this.checkPhysicalEventAvailability(createEventRequest);

        EventEntity eventEntity = this.eventRepository.save(EventMapper.toEntityFromCreateEventDto(createEventRequest));

        return CreateEventResponseMapper.toDtoFromEvent(EventMapper.toDto(eventEntity));
    }

    private void checkPhysicalEventAvailability(CreateEventRequest createEventRequest) {
        if (!createEventRequest.isOnline()) {
            if (!venueService.checkVenueStatusById(createEventRequest.getVenueId()).getBody())
                throw new NotFoundException(VENUE_NOT_AVAILABLE);

            if (!venueService.checkRoomStatusByIdAndCapacity(createEventRequest.getRoomId(), createEventRequest.getParticipantLimit()).getBody())
                throw new NotFoundException(ROOM_NOT_AVAILABLE);
        }
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
    public Event updateEventStatus(UUID id, boolean status) {
        EventEntity eventEntity = this.eventRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Event not found"));
        eventEntity.setActive(status);

        return EventMapper.toDto(this.eventRepository.save(eventEntity));
    }

    /**
     * Return all event instances in the database
     *
     * @return List<Event>. Please, see the {@link Event} class for details.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    @Override
    public List<Event> getAllEvents() {
        return EventMapper.toDtoList(this.eventRepository.findAll());
    }

    /**
     * Return an event instance by using its id in the database
     *
     * @param id event id to be filtered
     * @return Event. Please, see the {@link Event} class for details.
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    @Override
    public Event getEvent(UUID id) {
        return EventMapper.toDto(this.eventRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Event Not Found")));
    }

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
    @Override
    public Event updateEvent(UUID id, Event event) {
        if(!Objects.equals(id, event.getId()))
            throw new IllegalArgumentException("Ids do not match");
        if(!this.eventRepository.existsById(id))
            throw new NoSuchElementException("Event not found");

        return EventMapper.toDto(this.eventRepository.save(EventMapper.toEntity(event)));
    }
}

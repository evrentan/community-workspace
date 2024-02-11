package evrentan.community.eventmanager.impl;

import evrentan.community.eventmanager.dto.entity.Event;
import evrentan.community.eventmanager.dto.request.CreateEventRequest;
import evrentan.community.eventmanager.dto.response.CreateEventResponse;
import evrentan.community.eventmanager.entity.EventEntity;
import evrentan.community.eventmanager.exception.EventNotFoundException;
import evrentan.community.eventmanager.mapper.CreateEventResponseMapper;
import evrentan.community.eventmanager.mapper.EventMapper;
import evrentan.community.eventmanager.repository.EventRepository;
import evrentan.community.eventmanager.service.CommunityService;
import evrentan.community.eventmanager.service.EventService;
import evrentan.community.eventmanager.service.VenueService;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.*;

/**
 * Event Service Implementation for Event Service Layer.
 *
 * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Service
public class EventServiceImpl implements EventService {

    private static final String COMMUNITY_NOT_AVAILABLE = "Community is not available !!!";
    private static final String VENUE_NOT_AVAILABLE = "Venue is not available !!!";
    private static final String ROOM_NOT_AVAILABLE = "Room is not available !!!";

    private final EventRepository eventRepository;
    private final VenueService venueService;
    private final CommunityService communityService;

    public EventServiceImpl (EventRepository eventRepository, VenueService venueService, CommunityService communityService){
        this.eventRepository = eventRepository;
        this.venueService = venueService;
        this.communityService = communityService;
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

        this.doPreChecksForEventCreation(createEventRequest);

        EventEntity eventEntity = this.eventRepository.save(EventMapper.toEntityFromCreateEventDto(createEventRequest));

        return CreateEventResponseMapper.toDtoFromEvent(EventMapper.toDto(eventEntity));
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
        if (Objects.isNull(id) || Objects.isNull(event.getId()) || Objects.equals(id,event.getId()))
            throw  new BadRequestException("Bad Request");

        Optional<EventEntity> existCommunity = this.eventRepository.findById(id);
        if (existCommunity.isEmpty())
            throw new EventNotFoundException("Event Not Found");

        final Event updateEvent = this.save(event);

        if (Objects.isNull(updateEvent))
            throw new InternalServerErrorException("Event Not Updated");

        return updateEvent;
    }

    private void doPreChecksForEventCreation(CreateEventRequest createEventRequest) {
        this.checkCommunityAvailability(createEventRequest.getCommunityId());

        this.checkPhysicalEventAvailability(createEventRequest);
    }
    private void checkCommunityAvailability(UUID communityId) {
        if (!this.communityService.checkCommunityStatusById(communityId).getBody()) {
            throw new NoSuchElementException(COMMUNITY_NOT_AVAILABLE);
        }
    }

    private void checkPhysicalEventAvailability(CreateEventRequest createEventRequest) {
        if (!createEventRequest.isOnline()) {
            if (!this.venueService.checkVenueStatusById(createEventRequest.getVenueId()).getBody())
                throw new NotFoundException(VENUE_NOT_AVAILABLE);

            if (!this.venueService.checkRoomStatusByIdAndCapacity(createEventRequest.getRoomId(), createEventRequest.getParticipantLimit()).getBody())
                throw new NotFoundException(ROOM_NOT_AVAILABLE);
        }
    }

    private Event save(Event event){
        EventEntity eventEntity = EventMapper.toEntity(event);
        eventEntity = this.eventRepository.save(eventEntity);
        return EventMapper.toDto(eventEntity);
    }
}

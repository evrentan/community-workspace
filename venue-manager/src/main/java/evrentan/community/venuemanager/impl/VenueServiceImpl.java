package evrentan.community.venuemanager.impl;

import evrentan.community.venuemanager.dto.Venue;
import evrentan.community.venuemanager.dto.VenueRoom;
import evrentan.community.venuemanager.entity.VenueEntity;
import evrentan.community.venuemanager.mapper.VenueMapper;
import evrentan.community.venuemanager.mapper.VenueRoomMapper;
import evrentan.community.venuemanager.repository.VenueRepository;
import evrentan.community.venuemanager.repository.VenueRoomRepository;
import evrentan.community.venuemanager.service.VenueService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

/**
 * Venue Service Implementation for Venue Service Layer.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Service
public class VenueServiceImpl implements VenueService {

  private static final String VENUE_NOT_FOUND = "Venue does not exist !!!";

  private final VenueRepository venueRepository;
  private final VenueRoomRepository venueRoomRepository;

  public VenueServiceImpl(VenueRepository venueRepository, VenueRoomRepository venueRoomRepository) {
    this.venueRepository = venueRepository;
    this.venueRoomRepository = venueRoomRepository;
  }

  /**
   * Create a venue instance in the database
   *
   * @param venue venue to be created. Please, see the {@link Venue} class for details.
   * @return Venue which is created. Please, see the {@link Venue} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public Venue createVenue(Venue venue) {
    return VenueMapper.toDto(this.venueRepository.save(VenueMapper.toEntity(venue)));
  }

  /**
   * Return all venue instances in the database
   *
   * @return List<Venue>. Please, see the {@link Venue} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public List<Venue> getVenues() {
    return VenueMapper.toDtoList(this.venueRepository.findAll());
  }

  /**
   * Return a venue instance by using its id in the database
   *
   * @param id venue id to be filtered
   * @return Venue. Please, see the {@link Venue} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public Venue getVenue(UUID id) {
    return VenueMapper.toDto(this.venueRepository.findById(id).orElseThrow(() -> new NoSuchElementException(VENUE_NOT_FOUND)));
  }

  /**
   * Update a venue instance in the database
   *
   * @param id venue id to be updated.
   * @param venue venue instance to be updated. Please, see the {@link Venue} class for details.
   * @return Venue which is updated. Please, see the {@link Venue} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public Venue updateVenue(UUID id, Venue venue) {
    if(!Objects.equals(id, venue.getId()))
      throw new IllegalArgumentException("Ids do not match");

    this.checkVenueExists(id);

    return VenueMapper.toDto(this.venueRepository.save(VenueMapper.toEntity(venue)));
  }

  /**
   * Update a venue status instance in the database
   *
   * @param id venue id to be updated.
   * @param status status of the venue to be updated.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public Venue updateVenueStatus(UUID id, boolean status) {
    VenueEntity venueEntity = this.venueRepository.findById(id).orElseThrow(() -> new NoSuchElementException(VENUE_NOT_FOUND));
    venueEntity.setActive(status);

    return VenueMapper.toDto(this.venueRepository.save(venueEntity));
  }

  /**
   * Add room(s) to a specific venue object by venue ID
   *
   * @param venueId is the venue id that is going to be updated.
   * @param addedVenueRoomList is the new object that is going to be added to the existing one. Please, see the {@link VenueRoom} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public void addRooms(UUID venueId, List<VenueRoom> addedVenueRoomList) {
    this.checkVenueExists(venueId);

    //Remove the objects from the addedVenueRoomList request that has no room id
    addedVenueRoomList.removeIf(addedVenueRoom -> Objects.isNull(addedVenueRoom.getRoomId()));

    //Find the existing venue room list by venue id
    List<VenueRoom> venueRoomList = VenueRoomMapper.toDtoList(this.venueRoomRepository.findAllByVenueId(venueId));

    //Find passive room list by venue id and that are in the addedVenueRoomList
    List<UUID> passiveRoomIdList = venueRoomList.stream()
        .filter(venueRoom -> !venueRoom.isActive())
        .map(VenueRoom::getRoomId)
        .toList();
    passiveRoomIdList.forEach(passiveRoomId -> addedVenueRoomList.removeIf(addedVenueRoom -> Objects.equals(addedVenueRoom.getRoomId(), passiveRoomId)));

    //Set true to the passive room list
    List<VenueRoom> passiveVenueRoomList = VenueRoomMapper.toDtoList(this.venueRoomRepository.findAllByVenueIdAndRoomIdInAndActive(venueId, passiveRoomIdList, false));
    passiveVenueRoomList.forEach(venueRoomEntity -> venueRoomEntity.setActive(true));


    //Remove the objects from the addedVenueRoomList request that the room id already active in the venue
    List<UUID> roomIdList = venueRoomList.stream()
        .map(VenueRoom::getRoomId)
        .toList();
    addedVenueRoomList.removeIf(addedVenueRoom -> roomIdList.contains(addedVenueRoom.getRoomId()));

    //Set venue id and active to the addedVenueRoomList
    addedVenueRoomList.forEach(addedVenueRoom -> {
      addedVenueRoom.setVenueId(venueId);
      addedVenueRoom.setActive(true);
    });

    //Add the passive venue room list that is in the request to the final venue room list
    addedVenueRoomList.addAll(passiveVenueRoomList);

    this.venueRoomRepository.saveAll(VenueRoomMapper.toEntityList(addedVenueRoomList));
  }

  /**
   * Remove room(s) from a specific venue object by venue ID
   *
   * @param venueId is the venue id that is going to be updated.
   * @param removedVenueRoomList is the new object that is going to be added to the existing one. Please, see the {@link VenueRoom} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public void removeRooms(UUID venueId, List<VenueRoom> removedVenueRoomList) {
    this.checkVenueExists(venueId);

    //Remove the objects from the removedVenueRoomList request that has no room id
    removedVenueRoomList.removeIf(removedVenueRoom -> Objects.isNull(removedVenueRoom.getRoomId()));

    List<UUID> removedRoomIdList = removedVenueRoomList.stream().map(VenueRoom::getRoomId).toList();

    //Find the existing venue room list by venue id, room id and active
    List<VenueRoom> venueRoomList = VenueRoomMapper.toDtoList(this.venueRoomRepository.findAllByVenueIdAndRoomIdInAndActive(venueId, removedRoomIdList, true));

    venueRoomList.forEach(venueRoom -> venueRoom.setActive(false));

    this.venueRoomRepository.saveAll(VenueRoomMapper.toEntityList(venueRoomList));
  }

  /**
   * Check if the venue exists by venue ID
   * @param id is the venue id that is going to be checked.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public void checkVenueExists(UUID id) {
    if(Objects.isNull(id) || !this.venueRepository.existsById(id))
      throw new NoSuchElementException(VENUE_NOT_FOUND);
  }
}
package evrentan.community.venuemanager.service;

import evrentan.community.venuemanager.dto.Venue;
import evrentan.community.venuemanager.dto.VenueRoom;

import java.util.List;
import java.util.UUID;

/**
 * Venue Service Interface Class
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
public interface VenueService {

  /**
   * Create a venue instance in the database
   *
   * @param venue venue to be created. Please, see the {@link Venue} class for details.
   * @return Venue which is created. Please, see the {@link Venue} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  Venue createVenue(Venue venue);

  /**
   * Return all venue instances in the database
   *
   * @return List<Venue>. Please, see the {@link Venue} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  List<Venue> getVenues();

  /**
   * Return a venue instance by using its id in the database
   *
   * @param id venue id to be filtered
   * @return Venue. Please, see the {@link Venue} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  Venue getVenue(UUID id);

  /**
   * Return true if venue is active, otherwise false.
   *
   * @param id is the venue id that is going to be retrieved.
   * @return Boolean. true if Venue is active, otherwise false.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  Boolean checkVenueStatusById(UUID id);

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
  Venue updateVenue(UUID id, Venue venue);

  /**
   * Update a venue status instance in the database
   *
   * @param id venue id to be updated.
   * @param status status of the venue to be updated.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  void updateVenueStatus(UUID id, boolean status);

  /**
   * Add room(s) to a specific venue object by venue ID
   *
   * @param venueId is the venue id that is going to be updated.
   * @param addedVenueRoomList is the new object that is going to be added to the existing one. Please, see the {@link VenueRoom} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  void addRooms(UUID venueId, List<VenueRoom> addedVenueRoomList);

  /**
   * Remove room(s) from a specific venue object by venue ID
   *
   * @param venueId is the venue id that is going to be updated.
   * @param removedVenueRoomList is the new object that is going to be added to the existing one. Please, see the {@link VenueRoom} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  void removeRooms(UUID venueId, List<VenueRoom> removedVenueRoomList);

  /**
   * Check if the venue exists by venue ID
   * @param id is the venue id that is going to be checked.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  void checkVenueExists(UUID id);
}
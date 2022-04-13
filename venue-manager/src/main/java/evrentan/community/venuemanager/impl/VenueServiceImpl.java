package evrentan.community.venuemanager.impl;

import evrentan.community.venuemanager.dto.Venue;
import evrentan.community.venuemanager.entity.VenueEntity;
import evrentan.community.venuemanager.mapper.VenueMapper;
import evrentan.community.venuemanager.repository.VenueRepository;
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

  private final VenueRepository venueRepository;

  public VenueServiceImpl(VenueRepository venueRepository) {
    this.venueRepository = venueRepository;
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
    return VenueMapper.toDto(this.venueRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Venue not found")));
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

    if (!this.venueRepository.existsById(id))
      throw new NoSuchElementException("Venue not found");

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
    VenueEntity venueEntity = this.venueRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Venue not found"));
    venueEntity.setActive(status);

    return VenueMapper.toDto(this.venueRepository.save(venueEntity));
  }
}
package evrentan.community.eventmanager.mapper;

import evrentan.community.eventmanager.entity.EventEntity;
import evrentan.community.eventmanager.dto.EventDto;

import java.util.List;
import java.util.Objects;

/**
 * Event Mapper Class which maps EventEntity to EventDto and vice versa.
 *
 * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
 * @since 1.0.0
 */
public class EventMapper {

    /**
     * Maps EventDto to EventEntity
     * @param eventDto Entity to be mapped. Please, see the {@link EventDto} class for details.
     * @return EventEntity. Please, see the {@link EventEntity} class for details.
     *
     *  @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     *  @since 1.0.0
     */
    public static EventEntity toEntity(EventDto eventDto){
        if (Objects.isNull(eventDto))
            return null;

        return EventEntity.builder()
                .id(eventDto.getId())
                .name(eventDto.getName())
                .description(eventDto.getDescription())
                .isActive(eventDto.isActive())
                .eventDate(eventDto.getEventDate())
                .isOnline(eventDto.isOnline())
                .url(eventDto.getUrl())
                .isFree(eventDto.isFree())
                .eventFee(eventDto.getEventFee())
                .eventFeeCurrency(eventDto.getEventFeeCurrency())
                .participantLimit(eventDto.getParticipantLimit())
                .build();
    }

    /**
     * Maps CommunityEntity to Community.
     * @param eventEntity Entity to be mapped. Please, see the {@link EventEntity} class for details.
     * @return EventDto. Please, see the {@link EventDto} class for details.
     *
     *  @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     *  @since 1.0.0
     */
    public static EventDto toDto(EventEntity eventEntity){
        if (Objects.isNull(eventEntity))
            return null;

        return EventDto.builder()
                .id(eventEntity.getId())
                .name(eventEntity.getName())
                .description(eventEntity.getDescription())
                .isActive(eventEntity.isActive())
                .eventDate(eventEntity.getEventDate())
                .isOnline(eventEntity.isOnline())
                .url(eventEntity.getUrl())
                .isFree(eventEntity.isFree())
                .eventFee(eventEntity.getEventFee())
                .eventFeeCurrency(eventEntity.getEventFeeCurrency())
                .participantLimit(eventEntity.getParticipantLimit())
                .build();
    }

    /**
     * Maps List of Community to List of CommunityEntity.
     *
     * @param eventDtoList List of entities to be mapped. Please, see the {@link EventDto} class for details.
     * @return List of EventEntity. Please, see the {@link EventEntity} class for details.
     *
     *  @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     *  @since 1.0.0
     */
    public static List<EventEntity> toEntityList(List<EventDto> eventDtoList){
        return eventDtoList.stream().parallel()
                .map(EventMapper::toEntity)
                .toList();
    }


    /**
     * Maps List of CommunityEntity to List of Community.
     *
     * @param eventEntityList List of entities to be mapped. Please, see the {@link EventEntity} class for details.
     * @return List of Community. Please, see the {@link EventDto} class for details.
     *
     *  @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     *  @since 1.0.0
     */
    public static List<EventDto> toDtoList(List<EventEntity> eventEntityList){
        return eventEntityList.stream().parallel()
                .map(EventMapper::toDto)
                .toList();
    }
}

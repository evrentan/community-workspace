package evrentan.community.eventmanager.entity;

import evrentan.community.eventmanager.dto.entity.EventParticipant;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * EventParticipant Class represents the event_community table in the database.
 * It is represented by {@link EventParticipant} in DTO level.
 *
 * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
 * @since 1.0.0
 */
@Entity
@Table(name = "event_participant")
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class EventParticipantEntity {
    /**
     * Event Participant ID in UUID Type.
     * It is equalized to the id column in the database.
     * It is the primary key of the table.
     * It is auto-generated by the database.
     * It is unique.
     * It is not nullable.
     *
     * @since 1.0.0
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    /**
     * Event ID in UUID Type.
     *
     * @since 1.0.0
     */
    @Column(name = "event_id")
    private UUID eventId;

    /**
     * User ID in UUID Type.
     *
     * @since 1.0.0
     */
    @Column(name = "user_id")
    private UUID userId;

    /**
     * User Type ID in UUID Type.
     *
     * @since 1.0.0
     */
    @Column(name = "user_type_id")
    private UUID userTypeId;

    /**
     * Indicates if the event is active or not.
     *
     * @since 1.0.0
     */
    @Basic
    @Column(name = "is_active")
    private boolean isActive;




}

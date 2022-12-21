package evrentan.community.usermanager.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Pattern;
import java.util.UUID;

/**
 * User Type Entity Class represents the user_type table in the database.
 * It is represented by {@link evrentan.community.usermanager.dto.UserType} in DTO level.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Entity
@Table(name = "user_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode @ToString
@Builder
public class UserTypeEntity {

  /**
   * User Type ID in UUID Type. It is equalized to the id column in the database.
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
   * User Type Code in String Type.
   * It is equalized to the code column in the database.
   * Possible values may be "owner", "admin", "speaker", "member", "guest".
   *
   * @since 1.0.0
   */
  @Basic
  @Column(name = "code")
  @Pattern(regexp = "owner|admin|speaker|member|guest", flags = Pattern.Flag.CASE_INSENSITIVE)
  private String code;

  /**
   * User Type Description in String Type.
   * It is equalized to the description column in the database.
   *
   * @since 1.0.0
   */
  @Basic
  @Column(name = "description")
  private String description;

  /**
   * Indicates whether the user type is active or not.
   * It is equalized to the is_active column in the database.
   *
   * @since 1.0.0
   */
  @Basic
  @Column(name = "is_active")
  private boolean active;
}

package evrentan.community.usermanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.Pattern;
import java.util.UUID;

/**
 * User Type Class.
 * It is equalized to the {@link evrentan.community.usermanager.entity.UserTypeEntity} in entity level.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode @ToString
@Builder
@Schema(description = "User Type Class")
public class UserType {

  /**
   * User Type ID in UUID Type
   *
   * @since 1.0.0
   */
  @Schema(description = "Application User ID in UUID Type")
  private UUID id;

  /**
   * User Type Code in String Type.
   * Possible values may be "owner", "admin", "speaker", "member", "guest".
   *
   * @since 1.0.0
   */
  @Schema(description = "User Type Code in String Type. Possible values are owner, admin, user", allowableValues = {"owner", "admin", "speaker", "member", "guest"})
  @Pattern(regexp = "owner|admin|speaker|member|guest", flags = Pattern.Flag.CASE_INSENSITIVE)
  private String code;

  /**
   * User Type Description in String Type.
   *
   * @since 1.0.0
   */
  @Schema(description = "User Type Description in String Type")
  private String description;

  /**
   * Indicates if the user type is active or not.
   *
   * @since 1.0.0
   */
  @Schema(description = "Indicates if the user type is active or not.")
  @Builder.Default
  private boolean active = true;
}

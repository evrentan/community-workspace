package evrentan.community.usermanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.Pattern;
import java.util.UUID;

/**
 * Application User Class.
 * It is equalized to the {@link evrentan.community.usermanager.entity.ApplicationUserEntity} in entity level.
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
@Schema(description = "Application User Class")
public class ApplicationUser {

  /**
   * Application User ID in UUID Type
   *
   * @since 1.0.0
   */
  @Schema(description = "Application User ID in UUID Type")
  private UUID id;

  /**
   * Application User Full Name.
   *
   * @since 1.0.0
   */
  @Schema(description = "Application User Full Name")
  private String fullName;

  /**
   * Application User Email.
   *
   *  @since 1.0.0
   */
  @Schema(description = "Application User Email")
  @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
  private String email;

  /**
   * Application User Twitter Account.
   *
   * @since 1.0.0
   */
  @Schema(description = "Application User Twitter Account")
  private String twitterAccount;

  /**
   * Application User LinkedIn Account.
   *
   * @since 1.0.0
   */
  @Schema(description = "Application User Linkedin Account")
  private String linkedInAccount;

  /**
   * Application User GitHub Account.
   *
   * @since 1.0.0
   */
  @Schema(description = "Application User Github Account")
  private String githubAccount;

  /**
   * Application User Website URL.
   *
   * @since 1.0.0
   */
  @Schema(description = "Application User Website URL")
  private String websiteUrl;

  /**
   * Indicates if the application user is active or not.
   *
   * @since 1.0.0
   */
  @Schema(description = "Indicates if the application user is active or not.")
  private boolean isActive;
}

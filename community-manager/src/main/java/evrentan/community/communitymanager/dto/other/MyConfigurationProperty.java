package evrentan.community.communitymanager.dto.other;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * My Configuration Property Class that corresponds to properties in application.properties file that have prefixed "my.property".
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "my.property")
@Getter @Setter
@Schema(description = "MyConfigurationProperty Class")
public class MyConfigurationProperty {

  /**
   * Configuration Refresh property that corresponds to "my.property.configuration-refresh" property in String Type.
   *
   * @since 1.0.0
   */
  @Schema(description = "Configuration Refresh property that corresponds to \"my.property.configuration-refresh\" property in String Type")
  private String configurationRefresh;
}

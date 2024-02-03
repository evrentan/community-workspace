package evrentan.community.communitymanager.impl;

import evrentan.community.communitymanager.dto.other.MyConfigurationProperty;
import evrentan.community.communitymanager.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class TestServiceImpl implements TestService {

  @Value("${logging.level.org.hibernate.SQL}")
  private String hibernateSqlLoggingLevel;

  private final MyConfigurationProperty myConfigurationProperty;

  public TestServiceImpl(MyConfigurationProperty myConfigurationProperty) {
    this.myConfigurationProperty = myConfigurationProperty;
  }

  /**
   * Get hibernate sql logging level from application.properties file.
   * The related property is logging.level.org.hibernate.SQL in application.properties file.
   *
   * @return String Object that corresponds to "logging.level.org.hibernate.SQL" property in application.properties file.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public String getHibernateSqlLoggingLevel() {
    return String.format("Hibernate SQL Logging Level is %s", hibernateSqlLoggingLevel);
  }

  /**
   * Get configuration refresh property from application.properties file.
   * The related property is my.property.configuration-refresh in application.properties file.
   *
   * @return String Object that corresponds to "my.property.configuration-refresh" property in application.properties file.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public String getConfigurationRefreshProperty() {
    return String.format("Configuration Refresh Property is %s", myConfigurationProperty.getConfigurationRefresh());
  }
}

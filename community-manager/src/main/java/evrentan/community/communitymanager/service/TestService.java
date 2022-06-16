package evrentan.community.communitymanager.service;

public interface TestService {

  /**
   * Get hibernate sql logging level from application.properties file.
   * The related property is logging.level.org.hibernate.SQL in application.properties file.
   *
   * @return String Object that corresponds to "logging.level.org.hibernate.SQL" property in application.properties file.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  String getHibernateSqlLoggingLevel();

  /**
   * Get configuration refresh property from application.properties file.
   * The related property is my.property.configuration-refresh in application.properties file.
   *
   * @return String Object that corresponds to "my.property.configuration-refresh" property in application.properties file.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  String getConfigurationRefreshProperty();
}

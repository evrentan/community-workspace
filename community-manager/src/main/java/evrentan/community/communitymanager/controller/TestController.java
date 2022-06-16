package evrentan.community.communitymanager.controller;

import evrentan.community.communitymanager.service.TestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for test related API end-points.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/community/test", produces = "application/json", consumes = "application/json")
@Tag(name = "Test Related APIs")
public class TestController {

  private final TestService testService;

  public TestController(TestService testService) {
    this.testService = testService;
  }

  /**
   * REST end-point in order to get hibernate sql logging level from application.properties file.
   * The related property is logging.level.org.hibernate.SQL in application.properties file.
   *
   * @return String Object that corresponds to "logging.level.org.hibernate.SQL" property in application.properties file within ResponseEntity.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @GetMapping(value = "/getHibernateSqlLoggingLevel")
  @Operation(summary = "Get Hibernate SQL Logging Level from application.properties File")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Get Hibernate SQL Logging Level from application.properties File"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<String> getHibernateSqlLoggingLevel() {
    return ResponseEntity.ok(this.testService.getHibernateSqlLoggingLevel());
  }

  /**
   * REST end-point in order to get configuration refresh property from application.properties file.
   * The related property is my.property.configuration-refresh in application.properties file.
   *
   * @return String Object that corresponds to "my.property.configuration-refresh" property in application.properties file.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @GetMapping(value = "/getConfigurationRefreshProperty")
  @Operation(summary = "Get Configuration Refresh Property from application.properties File")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Get Configuration Refresh Property from application.properties File"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<String> getConfigurationRefreshProperty() {
    return ResponseEntity.ok(this.testService.getConfigurationRefreshProperty());
  }
}

package evrentan.community.usermanager.controller;

import evrentan.community.usermanager.dto.entity.UserType;
import evrentan.community.usermanager.service.UserTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;
import java.util.UUID;

/**
 * REST Controller for user type related API end-points.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/userType", produces = "application/json", consumes = "application/json")
@Tag(name = "User Type Related APIs")
public class UserTypeController {

  private final UserTypeService userTypeService;

  public UserTypeController(UserTypeService userTypeService) {
    this.userTypeService = userTypeService;
  }

  /**
   * REST end-point in order to create a user type.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param userType object that is going to be created. Please, see the {@link UserType} class for details.
   * @return UserType Object within ResponseEntity.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @PostMapping
  @Operation(summary = "Create a User Type")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "201", description  = "Successfully User Type Created"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<UserType> createUserType(@RequestBody @NotNull UserType userType) {
    final UserType userTypeCreated = this.userTypeService.createUserType(userType);
    return ResponseEntity.created(URI.create(userTypeCreated.getId().toString())).body(userTypeCreated);
  }

  /**
   * REST end-point in order to get all user types.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @return List of UserType Object within ResponseEntity. Please, see the {@link UserType} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @GetMapping
  @Operation(summary = "Get All User Types")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Get All User Types"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<List<UserType>> getAllUserTypes() {
    return ResponseEntity.ok(this.userTypeService.getUserTypes());
  }

  /**
   * REST end-point in order to retrieve a specific user type object by user type id.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param id is the user type id that is going to be retrieved.
   * @return UserType Object within ResponseEntity. Please, see the {@link UserType} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @GetMapping(value = "/{id}")
  @Operation(summary = "Get a User Type by Id")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Get the Related User Type"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<UserType> getUserType(@PathVariable(value = "id") UUID id) {
    return ResponseEntity.ok(this.userTypeService.getUserType(id));
  }

  /**
   * REST end-point in order to update a specific user type object by user type id.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param id is the user type id that is going to be updated.
   * @param userType is the new object that is going to be updated within the existing one. Please, see the {@link UserType} class for details.
   * @return UserType Object within ResponseEntity. Please, see the {@link UserType} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @PutMapping(value = "/{id}")
  @Operation(summary = "Update a User Type by Id")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "202", description  = "Successfully Update the Related User Type"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<UserType> updateUserType(@PathVariable(value = "id") UUID id, @RequestBody @NotNull UserType userType) {
    return ResponseEntity.accepted().body(this.userTypeService.updateUserType(id, userType));
  }

  /**
   * REST end-point in order to update a specific user type object status by user type id.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param id is the user type id that is going to be updated.
   * @return UserType Object within ResponseEntity. Please, see the {@link UserType} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @PatchMapping(value = "/updateUserTypeStatus")
  @Operation(summary = "Update a User Type Status by Id & Status value")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "202", description  = "Successfully Update the Related User Type Status"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity updateUserTypeStatus(@RequestParam(value = "id") @NotNull UUID id, @RequestBody @NotNull UserType userType) {
    this.userTypeService.updateUserTypeStatus(id, userType.isActive());
    return ResponseEntity.accepted().build();
  }
}

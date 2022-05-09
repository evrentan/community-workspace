package evrentan.community.usermanager.controller;

import evrentan.community.usermanager.dto.ApplicationUser;
import evrentan.community.usermanager.service.ApplicationUserService;
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
 * REST Controller for user related API end-points.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/user", produces = "application/json", consumes = "application/json")
@Tag(name = "User Type Related APIs")
public class ApplicationUserController {

  private final ApplicationUserService applicationUserService;

  public ApplicationUserController(ApplicationUserService applicationUserService) {
    this.applicationUserService = applicationUserService;
  }

  /**
   * REST end-point in order to create a user.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param applicationUser object that is going to be created. Please, see the {@link ApplicationUser} class for details.
   * @return ApplicationUser Object within ResponseEntity.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @PostMapping
  @Operation(summary = "Create a User")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "201", description  = "Successfully User Created"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<ApplicationUser> createUserType(@RequestBody @NotNull ApplicationUser applicationUser) {
    final ApplicationUser userCreated = this.applicationUserService.createUser(applicationUser);
    return ResponseEntity.created(URI.create(userCreated.getId().toString())).body(userCreated);
  }

  /**
   * REST end-point in order to get all users.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @return List of ApplicationUser Object within ResponseEntity. Please, see the {@link ApplicationUser} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @GetMapping
  @Operation(summary = "Get All Users")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Get All Users"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<List<ApplicationUser>> getAllUsers() {
    return ResponseEntity.ok(this.applicationUserService.getUsers());
  }

  /**
   * REST end-point in order to retrieve a specific user object by user id.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param id is the user id that is going to be retrieved.
   * @return ApplicationUser Object within ResponseEntity. Please, see the {@link ApplicationUser} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @GetMapping(value = "/{id}")
  @Operation(summary = "Get a User by Id")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Get the Related User"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<ApplicationUser> getUserById(@PathVariable(value = "id") UUID id) {
    return ResponseEntity.ok(this.applicationUserService.getUserById(id));
  }

  /**
   * REST end-point in order to retrieve a specific user object by user email.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param email is the user email that is going to be retrieved.
   * @return ApplicationUser Object within ResponseEntity. Please, see the {@link ApplicationUser} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @GetMapping(value = "/email/{email}")
  @Operation(summary = "Get a User by Email")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Get the Related User"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<ApplicationUser> getUserByEmail(@PathVariable(value = "email") String email) {
    return ResponseEntity.ok(this.applicationUserService.getUserByEmail(email));
  }

  /**
   * REST end-point in order to update a specific user object by user type id.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param id is the user type id that is going to be updated.
   * @param applicationUser is the new object that is going to be updated within the existing one. Please, see the {@link ApplicationUser} class for details.
   * @return ApplicationUser Object within ResponseEntity. Please, see the {@link ApplicationUser} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @PutMapping(value = "/{id}")
  @Operation(summary = "Update a User by Id")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "202", description  = "Successfully Update the Related User"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<ApplicationUser> updateUser(@PathVariable(value = "id") UUID id, @RequestBody @NotNull ApplicationUser applicationUser) {
    return ResponseEntity.accepted().body(this.applicationUserService.updateUser(id, applicationUser));
  }

  /**
   * REST end-point in order to update a specific user object status by user id.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param id is the user id that is going to be updated.
   * @return ApplicationUser Object within ResponseEntity. Please, see the {@link ApplicationUser} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @PatchMapping(value = "/updateUserStatusById")
  @Operation(summary = "Update a User Status by Id & Status value")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "202", description  = "Successfully Update the Related User Status"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity updateUserTypeStatusById(@RequestParam(value = "id") @NotNull UUID id, @RequestBody @NotNull ApplicationUser applicationUser) {
    this.applicationUserService.updateUserStatusById(id, applicationUser.isActive());
    return ResponseEntity.accepted().build();
  }
}

package evrentan.community.communitymanager.controller;

import evrentan.community.communitymanager.dto.Community;
import evrentan.community.communitymanager.service.CommunityService;
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
 * REST Controller for community related API end-points.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/community", produces = "application/json", consumes = "application/json")
@Tag(name = "Community Related APIs")
public class CommunityController {

  private final CommunityService communityService;

  public CommunityController(CommunityService communityService) {
    this.communityService = communityService;
  }

  /**
   * REST end-point in order to create a community.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param community object that is going to be created. Please, see the {@link Community} class for details.
   * @return Community Object within ResponseEntity.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @PostMapping
  @Operation(summary = "Create a Community")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Community Created"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<Community> createCommunity(@RequestBody @NotNull Community community) {
    final Community communityCreated = this.communityService.createCommunity(community);
    return ResponseEntity.created(URI.create(communityCreated.getId().toString())).body(communityCreated);
  }

  /**
   * REST end-point in order to get all communities.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @return List of Community Object within ResponseEntity. Please, see the {@link Community} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @GetMapping
  @Operation(summary = "Get All Communities")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Get All Communities"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<List<Community>> getAllCommunities() {
    return ResponseEntity.ok(this.communityService.getCommunities());
  }

  /**
   * REST end-point in order to retrieve a specific community object by community ID.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param id is the community id that is going to be retrieved.
   * @return Community Object within ResponseEntity. Please, see the {@link Community} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @GetMapping(value = "/{id}")
  @Operation(summary = "Get a Community by Id")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Get the Related Community"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<Community> getCommunity(@PathVariable(value = "id") UUID id) {
    return ResponseEntity.ok(this.communityService.getCommunity(id));
  }

  /**
   * REST end-point in order to check a specific community status is active by community ID.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param id is the community id that is going to be retrieved.
   * @return Boolean. true if Community is active, otherwise false
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @GetMapping(value = "/checkCommunityStatus/{id}")
  @Operation(summary = "Get a Community by Id")
  @ApiResponses(value = {
          @ApiResponse(responseCode  = "200", description  = "Successfully Get the Related Community"),
          @ApiResponse(responseCode  = "400", description  = "Bad Request"),
          @ApiResponse(responseCode  = "404", description  = "Not Found"),
          @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<Boolean> checkCommunityStatusById(@PathVariable(value = "id") UUID id) {
    return ResponseEntity.ok(this.communityService.checkCommunityStatusById(id));
  }

  /**
   * REST end-point in order to update a specific community object by community ID.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param id is the community id that is going to be updated.
   * @param community is the new object that is going to be updated within the existing one. Please, see the {@link Community} class for details.
   * @return Community Object within ResponseEntity. Please, see the {@link Community} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @PutMapping(value = "/{id}")
  @Operation(summary = "Update a Community by Id")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Update the Related Community"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<Community> updateCommunity(@PathVariable(value = "id") UUID id, @RequestBody @NotNull Community community) {
    return ResponseEntity.ok(this.communityService.updateCommunity(id, community));
  }

  /**
   * REST end-point in order to delete a specific community object by community ID.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param id is the community id that is going to be deleted.
   * @return Community Object within ResponseEntity. Please, see the {@link Community} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @PatchMapping(value = "/updateCommunityStatus")
  @Operation(summary = "Update a Community Status by Id & Status value")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Update the Related Community Status"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<Community> updateCommunityStatus(@RequestParam(value = "id") @NotNull UUID id, @RequestBody @NotNull Community community) {
    return ResponseEntity.ok(this.communityService.updateCommunityStatus(id, community.isActive()));
  }
}
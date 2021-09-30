/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.28-SNAPSHOT).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.AllPetsResponse;
import io.swagger.model.ModelApiResponse;
import io.swagger.model.Pet;
import io.swagger.model.SinglePetResponse;
import io.swagger.model.SubCategory;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@Validated
@Api(value = "Pet", description = "the Pet API")
public interface PetApi {

    @ApiOperation(value = "Add a new pet to the store", nickname = "addPet", notes = "", authorizations = {
        @Authorization(value = "petstore_auth", scopes = { 
            @AuthorizationScope(scope = "write:pets", description = "modify pets in your account"),
            @AuthorizationScope(scope = "read:pets", description = "read your pets")
            })    }, tags={ "pet", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/pet",
        consumes = "application/json",
        method = RequestMethod.POST)
    com.netflix.hystrix.HystrixCommand<ResponseEntity<Void>> addPet(@ApiParam(value = "Pet object that needs to be added to the store", required=true ) @Valid @RequestBody Pet body);


    @ApiOperation(value = "Deletes a pet", nickname = "deletePet", notes = "", authorizations = {
        @Authorization(value = "petstore_auth", scopes = { 
            @AuthorizationScope(scope = "write:pets", description = "modify pets in your account"),
            @AuthorizationScope(scope = "read:pets", description = "read your pets")
            })    }, tags={ "pet", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Pet not found") })
    @RequestMapping(value = "/pet/{petId}",
        method = RequestMethod.DELETE)
    com.netflix.hystrix.HystrixCommand<ResponseEntity<Void>> deletePet(@ApiParam(value = "Pet id to delete", required=true) @PathVariable("petId") Long petId, @ApiParam(value = "" ) @RequestHeader(value="api_key", required=false) String apiKey);


    @ApiOperation(value = "", nickname = "doCategoryStuff", notes = "", response = ModelApiResponse.class, tags={ "pet", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = ModelApiResponse.class) })
    @RequestMapping(value = "/pet/category",
        produces = "application/json", 
        consumes = "application/json",
        method = RequestMethod.POST)
    com.netflix.hystrix.HystrixCommand<ResponseEntity<ModelApiResponse>> doCategoryStuff(@ApiParam(value = "" ) @Valid @RequestBody SubCategory body);


    @ApiOperation(value = "Finds Pets by status", nickname = "findPetsByStatus", notes = "Multiple status values can be provided with comma separated strings", response = Pet.class, responseContainer = "List", authorizations = {
        @Authorization(value = "petstore_auth", scopes = { 
            @AuthorizationScope(scope = "write:pets", description = "modify pets in your account"),
            @AuthorizationScope(scope = "read:pets", description = "read your pets")
            })    }, tags={ "pet", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Pet.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid status value") })
    @RequestMapping(value = "/pet/findByStatus",
        produces = "application/json", 
        method = RequestMethod.GET)
    com.netflix.hystrix.HystrixCommand<ResponseEntity<List<Pet>>> findPetsByStatus(@NotNull @ApiParam(value = "Status values that need to be considered for filter", required = true, allowableValues="available, pending, sold"
) @Valid @RequestParam(value = "status", required = true) List<String> status);


    @ApiOperation(value = "Finds Pets by tags", nickname = "findPetsByTags", notes = "Muliple tags can be provided with comma separated strings. Use\\ \\ tag1, tag2, tag3 for testing.", response = Pet.class, responseContainer = "List", authorizations = {
        @Authorization(value = "petstore_auth", scopes = { 
            @AuthorizationScope(scope = "write:pets", description = "modify pets in your account"),
            @AuthorizationScope(scope = "read:pets", description = "read your pets")
            })    }, tags={ "pet", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Pet.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid tag value") })
    @RequestMapping(value = "/pet/findByTags",
        produces = "application/json", 
        method = RequestMethod.GET)
    com.netflix.hystrix.HystrixCommand<ResponseEntity<List<Pet>>> findPetsByTags(@NotNull @ApiParam(value = "Tags to filter by", required = true) @Valid @RequestParam(value = "tags", required = true) List<String> tags);


    @ApiOperation(value = "", nickname = "getAllPets", notes = "", response = AllPetsResponse.class, tags={ "pet", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "a single random pet", response = AllPetsResponse.class) })
    @RequestMapping(value = "/allPets",
        produces = "application/json", 
        method = RequestMethod.GET)
    com.netflix.hystrix.HystrixCommand<ResponseEntity<AllPetsResponse>> getAllPets();


    @ApiOperation(value = "Find pet by ID", nickname = "getPetById", notes = "Returns a single pet", response = Pet.class, authorizations = {
        @Authorization(value = "api_key")    }, tags={ "pet", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Pet.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Pet not found") })
    @RequestMapping(value = "/pet/{petId}",
        produces = "application/json", 
        method = RequestMethod.GET)
    com.netflix.hystrix.HystrixCommand<ResponseEntity<Pet>> getPetById(@ApiParam(value = "ID of pet to return", required=true) @PathVariable("petId") Long petId);


    @ApiOperation(value = "", nickname = "getRandomPet", notes = "", response = SinglePetResponse.class, tags={ "pet", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "a single random pet", response = SinglePetResponse.class) })
    @RequestMapping(value = "/randomPet",
        produces = "application/json", 
        method = RequestMethod.GET)
    com.netflix.hystrix.HystrixCommand<ResponseEntity<SinglePetResponse>> getRandomPet();


    @ApiOperation(value = "Update an existing pet", nickname = "updatePet", notes = "", authorizations = {
        @Authorization(value = "petstore_auth", scopes = { 
            @AuthorizationScope(scope = "write:pets", description = "modify pets in your account"),
            @AuthorizationScope(scope = "read:pets", description = "read your pets")
            })    }, tags={ "pet", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Pet not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/pet",
        consumes = "application/json",
        method = RequestMethod.PUT)
    com.netflix.hystrix.HystrixCommand<ResponseEntity<Void>> updatePet(@ApiParam(value = "Pet object that needs to be added to the store", required=true ) @Valid @RequestBody Pet body);


    @ApiOperation(value = "Updates a pet in the store with form data", nickname = "updatePetWithForm", notes = "", authorizations = {
        @Authorization(value = "petstore_auth", scopes = { 
            @AuthorizationScope(scope = "write:pets", description = "modify pets in your account"),
            @AuthorizationScope(scope = "read:pets", description = "read your pets")
            })    }, tags={ "pet", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/pet/{petId}",
        consumes = "application/x-www-form-urlencoded",
        method = RequestMethod.POST)
    com.netflix.hystrix.HystrixCommand<ResponseEntity<Void>> updatePetWithForm(@ApiParam(value = "ID of pet that needs to be updated", required=true) @PathVariable("petId") Long petId, @ApiParam(value = "") @RequestParam(value="name", required=false)  String name, @ApiParam(value = "") @RequestParam(value="status", required=false)  String status);


    @ApiOperation(value = "uploads an image", nickname = "uploadFile", notes = "", response = ModelApiResponse.class, authorizations = {
        @Authorization(value = "petstore_auth", scopes = { 
            @AuthorizationScope(scope = "write:pets", description = "modify pets in your account"),
            @AuthorizationScope(scope = "read:pets", description = "read your pets")
            })    }, tags={ "pet", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = ModelApiResponse.class) })
    @RequestMapping(value = "/pet/{petId}/uploadImage",
        produces = "application/json", 
        consumes = "application/octet-stream",
        method = RequestMethod.POST)
    com.netflix.hystrix.HystrixCommand<ResponseEntity<ModelApiResponse>> uploadFile(@ApiParam(value = "ID of pet to update", required=true) @PathVariable("petId") Long petId, @ApiParam(value = "" ) @Valid @RequestBody Object body);

}


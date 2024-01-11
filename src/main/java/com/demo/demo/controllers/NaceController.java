package com.demo.demo.controllers;

import com.demo.demo.entities.NaceEntity;
import com.demo.demo.model.ResourceNotFoundException;
import com.demo.demo.services.NaceDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NaceController {

    @Autowired
    private NaceDataService service;
    
    @Operation(
            summary = "Get the Nace entity",
            description = "Get the details for a specific nace entity",
            tags = {"NACE"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success", content = {@Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = NaceEntity.class)))}),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND: Entity could not be found")}
    )
    @GetMapping("/nace/{id}")
    public ResponseEntity<NaceEntity> getNaceDetails(@PathVariable Long id) {
        NaceEntity entity = service.getNaceEntity(id);
        return (entity==null)? ResponseEntity.notFound().build() : ResponseEntity.ok(entity);
    }

    @Operation(
            summary = "Put the Nace entity",
            description = "If the entity exists -> modify, if the entity doesn't exist -> create",
            tags = {"NACE"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entity modified"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST")
            }
    )
    @PutMapping("/nace/{id}")
    public ResponseEntity<NaceEntity> putNaceDetails(@RequestBody NaceEntity naceEntity, @PathVariable Long id) {
        return ResponseEntity.ok(service.putNaceEntity(naceEntity, id));
    }

    @Operation(
            summary = "Put the Nace entity",
            description = "If the entity exists -> modify, if the entity doesn't exist -> create",
            tags = {"NACE"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entity modified"),
            @ApiResponse(responseCode = "201", description = "Entity Created"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST")
    }
    )
    @PutMapping("/naceTests/{id}")
    public ResponseEntity<NaceEntity> putNaceDetails2(@RequestBody NaceEntity naceEntity, @PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.putNaceEntityTest(naceEntity, id));
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<NaceEntity>(service.postNaceEntityTest(naceEntity),HttpStatus.CREATED);
        }
    }

}

package com.demo.demo.controllers;

import com.demo.demo.entities.NaceEntity;
import com.demo.demo.services.NaceDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
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
        if(entity==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(entity);
    }

    @PutMapping("/nace/{id}")
    public NaceEntity putNaceDetails(@RequestBody NaceEntity naceEntity, @PathVariable Long id) {
        return service.putNaceEntity(naceEntity, id);
    }

}

package com.demo.demo.controllers;

import com.demo.demo.entities.NaceEntity;
import com.demo.demo.services.NaceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NaceController {

    @Autowired
    private NaceDataService service;


    @GetMapping("/nace/{id}")
    public @ResponseBody NaceEntity getNaceDetails(@PathVariable Long id) {
        return service.getNaceEntity(id);
    }

    @PutMapping("/nace/{id}")
    public @ResponseBody NaceEntity putNaceDetails(@RequestBody NaceEntity naceEntity, @PathVariable Long id) {
        return service.putNaceEntity(naceEntity, id);
    }

}

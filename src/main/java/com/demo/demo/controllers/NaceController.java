package com.demo.demo.controllers;

import com.demo.demo.entities.NaceEntity;
import com.demo.demo.services.NaceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NaceController {

    @Autowired
    private NaceDataService service;


    @GetMapping("/nace/{id}")
    public @ResponseBody NaceEntity nace(@PathVariable Long id) {
        return service.getNaceEntity(id);
    }
}

package com.demo.demo.controllers;

import com.demo.demo.entities.NaceEntity;
import com.demo.demo.services.NaceDataService;
import org.springframework.beans.factory.annotation.Autowired;

public class NaceController implements INaceController{

    @Autowired
    private NaceDataService service;

    @Override
    public NaceEntity nace(Long id) {
        return service.getNaceEntity(id);
    }
}

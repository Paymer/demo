package com.demo.demo.controllers;

import com.demo.demo.entities.NaceEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface INaceController {

    @GetMapping("/nace")
    NaceEntity nace (@RequestParam(value = "id") Long id);

}

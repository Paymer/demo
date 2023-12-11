package com.demo.demo.controllers;

import com.demo.demo.entities.NaceEntity;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.List;

@Component
public interface INaceDataExtractor {

    List<NaceEntity> getNaceData(String fileName) throws FileNotFoundException;
}

package com.demo.demo.controllers;

import com.demo.demo.entities.NaceEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NaceDataExcelExtractorTest {

    private static final String BASE = "src/main/resources/static/";

    @Autowired
    INaceDataExtractor dataExtractor = new NaceDataExcelExtractor();

    @Test
    public void getDataTestOneRowOneEntity () throws FileNotFoundException {
        List<NaceEntity> result = dataExtractor.getNaceData(BASE +"gftTest.csv");
        assertEquals(3, result.size());
    }

    @Test
    public void getDataTestWithMultipleLinesForAColumn () throws FileNotFoundException {
        List<NaceEntity> result = dataExtractor.getNaceData(BASE +"gft_forExercise.csv");
        assertEquals(996, result.size());
    }

}

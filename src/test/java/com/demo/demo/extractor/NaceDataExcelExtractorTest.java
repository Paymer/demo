package com.demo.demo.extractor;

import com.demo.demo.entities.NaceEntity;
import com.demo.demo.extractor.INaceDataExtractor;
import com.demo.demo.extractor.NaceDataExcelExtractor;
import com.demo.demo.model.DemoException;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NaceDataExcelExtractorTest {

    @Autowired
    INaceDataExtractor dataExtractor = new NaceDataExcelExtractor();

    @Test
    public void getNaceEntitiesFromFile_ok () throws DemoException {
        List<NaceEntity> result = dataExtractor.getNaceData("gftTest.csv");
        assertEquals(996, result.size());
    }

    @Test
    public void getNaceEntitiesFromInexistingFile_ko () throws DemoException {

        assertThrows(
                DemoException.class,
                () -> dataExtractor.getNaceData("InexistingFile.csv"),
                "Expected doThing() to throw, but it didn't"
        );

    }
}

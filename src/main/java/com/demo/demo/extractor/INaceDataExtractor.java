package com.demo.demo.extractor;

import com.demo.demo.entities.NaceEntity;
import com.demo.demo.model.DemoException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface INaceDataExtractor {

    List<NaceEntity> getNaceData(String location) throws DemoException;

    List<NaceEntity> getNaceData() throws DemoException ;
}

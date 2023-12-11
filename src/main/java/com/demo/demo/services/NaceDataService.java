package com.demo.demo.services;

import com.demo.demo.controllers.INaceDataExtractor;
import com.demo.demo.entities.NaceEntity;
import com.demo.demo.repositories.NaceRepository;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class NaceDataService {

//    private final NaceRepository repository;
    private final INaceDataExtractor extractor;

    private final List<NaceEntity> naceList;

    public NaceDataService (/*NaceRepository repository, */INaceDataExtractor extractor) throws FileNotFoundException {
//        this.repository = repository;
        this.extractor = extractor;

        naceList =  extractor.getNaceData("src/main/resources/static/gftTest.csv");
       // naceList.stream().forEach(n -> repository.save(n));
    }

    public NaceEntity getNaceEntity (Long id){
        //return repository.findById(id).orElse(null);
        return naceList.get(1);
    }

}

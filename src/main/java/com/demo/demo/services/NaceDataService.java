package com.demo.demo.services;

import com.demo.demo.extractor.INaceDataExtractor;
import com.demo.demo.entities.NaceEntity;
import com.demo.demo.model.DemoException;
import com.demo.demo.model.ResourceNotFoundException;
import com.demo.demo.repositories.NaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NaceDataService {
    private NaceRepository repository;
    private INaceDataExtractor extractor;

   public NaceDataService (NaceRepository repository, INaceDataExtractor extractor) throws DemoException {
        this.repository = repository;
        this.extractor = extractor;

        List<NaceEntity> naceList =  extractor.getNaceData();
        naceList.forEach(n -> {
            try {
                repository.save(n);
            }catch(Exception e){
                //do nothing
            }
        });
    }

    public NaceEntity getNaceEntity (Long id){
        return repository.findById(id).orElse(null);
    }

    public NaceEntity putNaceEntity (NaceEntity entity, Long id) {
        return repository.findById(id)
                .map(ent -> modifyNaceEntity(entity, ent))
                .orElseGet(() -> {
                    entity.setOrder(id);
                    return repository.save(entity);
                });
    }

    public NaceEntity putNaceEntityTest(NaceEntity entityDetails, Long id) throws ResourceNotFoundException {

       NaceEntity entity = repository.findById(id)
               .map(ent -> modifyNaceEntity(entityDetails, ent))
               .orElseThrow(() -> new ResourceNotFoundException("NaceEntity not found for this id :: " + id));

        return repository.save(entity);
    }

    public NaceEntity postNaceEntityTest(NaceEntity entityDetails) {
        return  repository.save(entityDetails);
    }

    private NaceEntity modifyNaceEntity(NaceEntity entityDetails, NaceEntity entityFromDDBB) {
        entityFromDDBB.setLevel(Integer.valueOf(entityDetails.getLevel()));
        entityFromDDBB.setCode(entityDetails.getCode());
        entityFromDDBB.setParent(entityDetails.getParent());
        entityFromDDBB.setDescription(entityDetails.getDescription());
        entityFromDDBB.setItemIncludes(entityDetails.getItemIncludes());
        entityFromDDBB.setAlsoIncludes(entityDetails.getAlsoIncludes());
        entityFromDDBB.setRulings(entityDetails.getRulings());
        entityFromDDBB.setItemExcludes(entityDetails.getItemExcludes());
        entityFromDDBB.setReferenceIsic(entityDetails.getReferenceIsic());
        return repository.save(entityFromDDBB);
    }

}

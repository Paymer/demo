package com.demo.demo.services;

import com.demo.demo.extractor.INaceDataExtractor;
import com.demo.demo.entities.NaceEntity;
import com.demo.demo.model.DemoException;
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
        naceList.forEach(n -> repository.save(n));
    }

    public NaceEntity getNaceEntity (Long id){
        return repository.findById(id).orElse(null);
    }

    public NaceEntity putNaceEntity (NaceEntity entity, Long id){
        return repository.findById(entity.getOrder())
                .map(ent -> {
                    ent.setLevel(Integer.valueOf(entity.getLevel()));
                    ent.setCode(entity.getCode());
                    ent.setParent(entity.getParent());
                    ent.setDescription(entity.getDescription());
                    ent.setItemIncludes(entity.getItemIncludes());
                    ent.setAlsoIncludes(entity.getAlsoIncludes());
                    ent.setRulings(entity.getRulings());
                    ent.setItemExcludes(entity.getItemExcludes());
                    ent.setReferenceIsic(entity.getReferenceIsic());
                    return repository.save(ent);
                })
                .orElseGet(() -> {
                    entity.setOrder(id);
                    return repository.save(entity);
                });
    }

}

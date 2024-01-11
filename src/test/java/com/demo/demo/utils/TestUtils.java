package com.demo.demo.utils;

import com.demo.demo.entities.NaceEntity;

public class TestUtils {

    public static NaceEntity createEntity(Long i){
        NaceEntity entity =new NaceEntity();
        entity.setOrder(i);
        entity.setRulings("rulings"+i);
        entity.setReferenceIsic("referenceIsic"+i);
        entity.setAlsoIncludes("alsoIncludes"+i);
        entity.setItemExcludes("itemExcludes"+i);
        entity.setDescription("description"+i);
        entity.setParent("P"+i);
        entity.setCode("A"+i);
        entity.setItemIncludes("itemIncludes"+i);
        entity.setLevel(1);
        return entity;
    }

    public static NaceEntity createEntity(Long i, int level, String code, String parent,
                                          String descriprion, String itemIncl, String alsoIncl,
                                          String itemExcl,
                                          String rulings, String referenceIsic){

        NaceEntity entity =new NaceEntity();
        entity.setOrder(i);
        entity.setRulings(rulings);
        entity.setReferenceIsic(referenceIsic);
        entity.setAlsoIncludes(alsoIncl);
        entity.setItemExcludes(itemExcl);
        entity.setDescription(descriprion);
        entity.setParent(parent);
        entity.setCode(code);
        entity.setItemIncludes(itemIncl);
        entity.setLevel(level);
        return entity;
    }
}

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
        entity.setParent("parent"+i);
        entity.setCode("code"+i);
        entity.setItemIncludes("itemIncludes"+i);
        entity.setLevel(1);
        return entity;
    }
}

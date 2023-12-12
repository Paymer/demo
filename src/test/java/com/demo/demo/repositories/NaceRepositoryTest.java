package com.demo.demo.repositories;

import com.demo.demo.entities.NaceEntity;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class NaceRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private NaceRepository repository;


    @Test
    @Ignore
    void whenSaved_thenFindsById() {
//        entityManager.persist(createEntity(1L));
        repository.save(createEntity(1L));
        assertNotNull(repository.findById(1L));
    }

    public NaceEntity createEntity(Long i){
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

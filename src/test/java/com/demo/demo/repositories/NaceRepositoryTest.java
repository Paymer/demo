package com.demo.demo.repositories;

import com.demo.demo.entities.NaceEntity;
import com.demo.demo.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class NaceRepositoryTest {

    @Autowired
    private NaceRepository repository;

    @Test
    void saveTest() {
        NaceEntity entitySaved = repository.save(TestUtils.createEntity(3L));
        assert(entitySaved.getOrder().equals(3L));
    }

    @Test
    void getByIdTest() {
        NaceEntity entitySaved = repository.save(TestUtils.createEntity(4L));
        assertNotNull(repository.findById(entitySaved.getOrder()));
    }

}

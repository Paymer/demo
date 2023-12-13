package com.demo.demo.repositories;

import com.demo.demo.DemoApplication;
import com.demo.demo.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes={DemoApplication.class})
public class NaceRepositoryTest {

    @Autowired
    private NaceRepository repository;


    @Test
    void whenSaved_thenFindsById() {
        repository.save(TestUtils.createEntity(1L));
        assertNotNull(repository.findById(1L));
    }


}

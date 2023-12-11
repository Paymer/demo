package com.demo.demo.repositories;

import com.demo.demo.entities.NaceEntity;
import org.springframework.data.repository.CrudRepository;

public interface NaceRepository extends CrudRepository<NaceEntity, Long> {
    NaceEntity findById(long id);
}

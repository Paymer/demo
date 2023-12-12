package com.demo.demo.repositories;

import com.demo.demo.entities.NaceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaceRepository extends CrudRepository<NaceEntity, Long> {
    NaceEntity findById(long id);
}

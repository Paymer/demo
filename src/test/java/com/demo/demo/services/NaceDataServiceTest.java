package com.demo.demo.services;

import com.demo.demo.extractor.INaceDataExtractor;
import com.demo.demo.entities.NaceEntity;
import com.demo.demo.model.DemoException;
import com.demo.demo.model.ResourceNotFoundException;
import com.demo.demo.repositories.NaceRepository;
import com.demo.demo.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class NaceDataServiceTest {
    private NaceDataService service;
    @Mock
    private NaceRepository repository;
    @Mock
    private INaceDataExtractor extractor;

    @BeforeEach
    private void setUp () throws DemoException {
        MockitoAnnotations.openMocks(this);
        when(extractor.getNaceData()).thenReturn(List.of(TestUtils.createEntity(1L), TestUtils.createEntity(2L)));
        service = new NaceDataService(repository, extractor);

    }

    @Test
    void getNaceEntity_returnsEntityOK(){
        when(repository.save(any(NaceEntity.class))).thenReturn(TestUtils.createEntity(2L));
        when(repository.findById(any())).thenReturn(Optional.of(TestUtils.createEntity(2L)));

        NaceEntity result = service.getNaceEntity(2L);

       assert(TestUtils.createEntity(2L).equals(result));
      // verify(repository, times(1)).findById(2L);
      // verify(repository, times(2)).save(result);//extractor saving entities
    }

    @Test
    void putNaceEntity_throwsException(){
        when(repository.findById(any())).thenReturn(Optional.empty());
        assertThrows(
                ResourceNotFoundException.class,
                () -> service.putNaceEntityTest( TestUtils.createEntity(3L), 3L),
                ""
        );
    }

    @Test
    void putNaceEntity_returnsEntity(){
        NaceEntity expected = TestUtils.createEntity(2L);

        when(repository.save(any(NaceEntity.class))).thenReturn(expected);
        when(repository.findById(any())).thenReturn(Optional.of(expected));

        NaceEntity result = service.putNaceEntity( TestUtils.createEntity(2L), 2L);

        assert(expected.equals(result));

    }
}

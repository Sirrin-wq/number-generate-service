package org.example.numbergenerateservice.service.impl;

import org.example.numbergenerateservice.model.GeneratedNumberEntity;
import org.example.numbergenerateservice.repository.NumberRepository;
import org.example.numbergenerateservice.service.NumberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NumberServiceImplTest {
    @Mock
    private NumberRepository repository;
    @InjectMocks
    private NumberServiceImpl service;

    @Test
    void testGenerateUniqueNumber() {
        GeneratedNumberEntity mockEntity = new GeneratedNumberEntity("1", "1111120241212", LocalDateTime.now());
        when(repository.save(any())).thenReturn(mockEntity);

        GeneratedNumberEntity result = service.generate();
        assertNotNull(result);
        assertEquals(5, result.getFullNumber().substring(0, 5).length());
    }
}

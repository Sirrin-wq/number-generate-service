package org.example.numbergenerateservice.service;

import org.example.numbergenerateservice.model.GeneratedNumberEntity;

/**
 * Service interface for generating numbers.
 */
public interface NumberService {
    /**
     * Generates a new number entity.
     *
     * @return A {@link GeneratedNumberEntity} containing the newly generated number.
     */
    GeneratedNumberEntity generate();
}
package org.example.numbergenerateservice.repository;

import org.example.numbergenerateservice.model.GeneratedNumberEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository interface for managing GeneratedNumberEntity objects in MongoDB.
 * This interface extends MongoRepository to provide CRUD operations and custom query methods for GeneratedNumberEntity.
 */
public interface NumberRepository extends MongoRepository<GeneratedNumberEntity, String> {
}

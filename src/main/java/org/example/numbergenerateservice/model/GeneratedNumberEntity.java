package org.example.numbergenerateservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDateTime;

/**
 * Represents a generated number entity in the system.
 * This class is mapped to the "generated_numbers" collection in MongoDB.
 * It includes a compound index on the 'fullNumber' field to ensure uniqueness.
 */
@Document(collection = "generated_numbers")
@CompoundIndex(name = "fullNumber_unique", def = "{'fullNumber': 1}", unique = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneratedNumberEntity {
    /**
     * The unique identifier for the generated number entity.
     */
    @Id
    private String id;

    /**
     * The full generated number as a string.
     * This field is indexed to ensure uniqueness across all documents.
     */
    private String fullNumber;

    /**
     * The timestamp when the number was generated.
     */
    private LocalDateTime createdAt;
}

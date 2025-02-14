package org.example.numbergenerateservice.service.impl;

import com.mongodb.DuplicateKeyException;
import lombok.RequiredArgsConstructor;
import org.example.numbergenerateservice.model.GeneratedNumberEntity;
import org.example.numbergenerateservice.repository.NumberRepository;
import org.example.numbergenerateservice.service.NumberService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NumberServiceImpl implements NumberService {
    private final NumberRepository repository;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.BASIC_ISO_DATE;
    private static final int MAX_RETRIES = 3;

    /**
     * Generates a unique number entity and saves it to the repository.
     * 
     * This method attempts to create a unique number by combining a randomly generated
     * string with the current date. It will retry up to MAX_RETRIES times if a duplicate
     * key exception occurs when saving to the repository.
     *
     * @return GeneratedNumberEntity The newly created and saved number entity.
     * @throws RuntimeException If a unique number cannot be generated after MAX_RETRIES attempts,
     *                          or if the generation process fails for any other reason.
     */
    @Override
    public GeneratedNumberEntity generate() {
        int retries = 0;
        while (retries < MAX_RETRIES) {
            String numberPart = generateUniqueNumber();
            String datePart = LocalDate.now().format(DATE_FORMATTER);
            String fullNumber = numberPart + datePart;

            GeneratedNumberEntity entity = new GeneratedNumberEntity(null, fullNumber, LocalDateTime.now());

            try {
                return repository.save(entity);
            } catch (DuplicateKeyException e) {
                retries++;
                if (retries >= MAX_RETRIES) {
                    throw new RuntimeException("Failed to generate a unique number after " + MAX_RETRIES + " attempts");
                }
            }
        }
        throw new RuntimeException("Failed to generate a unique number");
    }

    /**
     * Generates a unique 5-character string.
     *
     * This method creates a UUID, takes its first 5 characters, and converts them to uppercase.
     *
     * @return String A 5-character uppercase string derived from a UUID.
     */
    private String generateUniqueNumber() {
        return UUID.randomUUID().toString().substring(0, 5).toUpperCase();
    }
}

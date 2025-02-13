package org.example.numbergenerateservice.service.impl;

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

    @Override
    public GeneratedNumberEntity generate() {
        String numberPart = generateUniqueNumber();
        String datePart = LocalDate.now().format(DATE_FORMATTER);
        String fullNumber = numberPart + datePart;

        GeneratedNumberEntity entity = new GeneratedNumberEntity(null, fullNumber, LocalDateTime.now());
        return repository.save(entity);
    }

    private String generateUniqueNumber() {
        return UUID.randomUUID().toString().substring(0, 5).toUpperCase();
    }
}

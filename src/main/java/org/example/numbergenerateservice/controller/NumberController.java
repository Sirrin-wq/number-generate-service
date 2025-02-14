package org.example.numbergenerateservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.numbergenerateservice.model.GeneratedNumberEntity;
import org.example.numbergenerateservice.service.NumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling number generation requests.
 */
@RestController
@RequestMapping("/numbers")
@RequiredArgsConstructor
public class NumberController {
    private final NumberService service;

    /**
     * Generates a new number using the NumberService.
     *
     * @return ResponseEntity containing the generated number as a String
     */
    @GetMapping
    public ResponseEntity<String> generateNumber() {
        GeneratedNumberEntity number = service.generate();
        return ResponseEntity.ok(number.getFullNumber());
    }
}

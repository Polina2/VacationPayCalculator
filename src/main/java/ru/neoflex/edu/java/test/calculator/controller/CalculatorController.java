package ru.neoflex.edu.java.test.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.edu.java.test.calculator.dto.CalculatePayResponse;
import ru.neoflex.edu.java.test.calculator.dto.CalculatePayRequest;

@RestController
public class CalculatorController {
    @GetMapping("/calculate")
    public CalculatePayResponse calculate(@RequestBody CalculatePayRequest request) {
        return null;
    }
}

package com.masters.microservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health/check")
    public String healthCheck() {
        return "I'm healthy";
    }
}

package com.masters.microservice.controller;

import com.masters.crud.controller.TicketController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    Logger loggerFactory = LoggerFactory.getLogger(TicketController.class);

    @GetMapping("/health/check")
    public String healthCheck() {
        int variable = 0;
        loggerFactory.debug("Health check started {}", variable);
        return "I'm healthy";
    }
}

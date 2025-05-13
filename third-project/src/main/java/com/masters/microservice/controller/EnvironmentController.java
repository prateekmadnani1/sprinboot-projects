package com.masters.microservice.controller;

import com.masters.microservice.request.EnvironmentRequestVo;
import com.masters.microservice.response.EnvironmentResponseVo;
import com.masters.microservice.service.EnvironmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Environments Controller.
 */
@RestController
public class EnvironmentController {

    private final EnvironmentService environmentService;
    private static final Logger logger = LoggerFactory.getLogger(EnvironmentController.class);

    public EnvironmentController(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    /**
     * Method to get a particular environment under a platform.
     * @param platformName refers to the platform name.
     * @param environmentName refers to the environment name.
     */
    @GetMapping("/platform/{platformName}/environment/{environmentName}")
    public ResponseEntity<EnvironmentResponseVo> getEnvironmentByName(
            @PathVariable("platformName") String platformName,
            @PathVariable("environmentName") String environmentName) {
        logger.info("In EnvironmentController:: getEnvironmentByName ::::" + platformName);
        return new ResponseEntity<>(environmentService.getEnvironmentByName(platformName, environmentName), HttpStatus.OK);
    }

    @PostMapping("/health")
    public ResponseEntity<EnvironmentResponseVo> register(
            @RequestBody EnvironmentRequestVo environmentRequestVo) {
        logger.info("In EnvironmentController:: registerEnvironment ::::" + environmentRequestVo);
        return new ResponseEntity<>(environmentService.registerEnvironment(environmentRequestVo), HttpStatus.CREATED);
    }

    /**
     * Method to get all environments under a platform.
     * @param platformName refers to the platform name.
     */
    @GetMapping("/platform/{platformName}")
    public ResponseEntity<List<EnvironmentResponseVo>> getAllEnvironments(
            @PathVariable("platformName") String platformName) {
        logger.info("In EnvironmentController:: getAllEnvironments :::: " + platformName);
        return new ResponseEntity<>(environmentService.getAllEnvironments(platformName), HttpStatus.OK);
    }

    /**
     * Method to register an environment under a platform.
     * @param environmentRequestVo refers to the new environment that is to be registered on the platform.
     */
    @PostMapping("/environments")
    public ResponseEntity<EnvironmentResponseVo> registerEnvironment(
            @RequestBody EnvironmentRequestVo environmentRequestVo) {
        logger.info("In EnvironmentController:: registerEnvironment ::::" + environmentRequestVo);
        return new ResponseEntity<>(environmentService.registerEnvironment(environmentRequestVo), HttpStatus.CREATED);
    }

    /**
     * Method to update existing environments under a platform.
     * @param environmentRequestVo refers to the environment that is to be updated on the platform.
     */
    @PutMapping
    public ResponseEntity<EnvironmentResponseVo> updateEnvironment(
            @RequestBody EnvironmentRequestVo environmentRequestVo) {
        logger.info("In EnvironmentController:: updateEnvironment ::::" + environmentRequestVo);
        return ResponseEntity.ok(environmentService.updateEnvironment(environmentRequestVo));
    }

    /**
     * Method to delete a particular environment under a platform.
     * @param environmentRequestVo refers to the environment that is to be deleted from the platform.
     */
    @DeleteMapping
     public ResponseEntity<EnvironmentResponseVo> deleteEnvironment(
            @RequestBody EnvironmentRequestVo environmentRequestVo) {
        logger.info("In EnvironmentController:: deleteEnvironment :::platformName::"
                + environmentRequestVo.getPlatformName() + ", environmentName::"
                + environmentRequestVo.getEnvironmentName());
        return new ResponseEntity<>(environmentService.deleteEnvironment(environmentRequestVo), HttpStatus.OK);
    }
}

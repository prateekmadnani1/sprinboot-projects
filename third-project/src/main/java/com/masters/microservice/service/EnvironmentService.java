package com.masters.microservice.service;

import com.masters.microservice.request.EnvironmentRequestVo;
import com.masters.microservice.response.EnvironmentResponseVo;

import java.util.List;

/**
 * Service interface for managing environments.
 */
public interface EnvironmentService {

    /**
     * Get environment details by name under a platform.
     *
     * @param platformName the platform name
     * @param environmentName the environment name
     * @return EnvironmentResponseVo containing environment details
     */
    EnvironmentResponseVo getEnvironmentByName(String platformName, String environmentName);

    /**
     * Get all environments under a platform.
     *
     * @param platformName the platform name
     * @return List of EnvironmentResponseVo
     */
    List<EnvironmentResponseVo> getAllEnvironments(String platformName);

    /**
     * Register a new environment under a platform.
     *
     * @param environmentRequestVo the environment request object
     * @return EnvironmentResponseVo containing created environment details
     */
    EnvironmentResponseVo registerEnvironment(EnvironmentRequestVo environmentRequestVo);

    /**
     * Update an existing environment under a platform.
     *
     * @param environmentRequestVo the environment request object
     * @return EnvironmentResponseVo containing updated environment details
     */
    EnvironmentResponseVo updateEnvironment(EnvironmentRequestVo environmentRequestVo);

    /**
     * Delete an existing environment under a platform.
     *
     * @param environmentRequestVo the environment request object
     * @return EnvironmentResponseVo containing deleted environment details
     */
    EnvironmentResponseVo deleteEnvironment(EnvironmentRequestVo environmentRequestVo);
}

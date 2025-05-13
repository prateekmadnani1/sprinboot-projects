package com.masters.microservice.service.impl;
import java.util.List;

import com.masters.microservice.adapter.Adapter;
import com.masters.microservice.request.EnvironmentRequestVo;
import com.masters.microservice.response.EnvironmentResponseVo;
import com.masters.microservice.service.EnvironmentService;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * Environment Service Implementation.
 */
@Service
public class EnvironmentServiceImpl implements EnvironmentService {

    private final Adapter adapter;
    private static final Logger logger = LoggerFactory.getLogger(EnvironmentServiceImpl.class);

    public EnvironmentServiceImpl(Adapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public EnvironmentResponseVo getEnvironmentByName(final String platformName, final String environmentName) {
        logger.debug("In EnvironmentServiceImpl:: getEnvironmentByName ::::" + platformName
                + ", environmentName::" + environmentName);

        List<EnvironmentResponseVo> environmentResponseVoList = getAllEnvironments(platformName);

        if (CollectionUtils.isEmpty(environmentResponseVoList)) {
            logger.debug("No environments were found for the platform::" + platformName);
            //throw new ResourceNotFoundException(ErrorCodes.ENVIRONMENTS_NOT_FOUND);
        }

        return environmentResponseVoList.stream()
                .filter(object -> object.getName().equalsIgnoreCase(environmentName))
                .findAny()
                .orElseThrow(() -> {
                    logger.debug("Environment::" + environmentName + " could not be found for platform::" + platformName);
                   // return new ResourceNotFoundException(ErrorCodes.ENVIRONMENT_NOT_FOUND);
                    return null;
                });

    }

    @Override
    public List<EnvironmentResponseVo> getAllEnvironments(final String platformName) {
        logger.debug("In EnvironmentServiceImpl:: getAllEnvironments ::::" + platformName);

        String applicationId = "Utility.getApplicationIdFromPlatformName(platformName)";
        if (Strings.isEmpty(applicationId)) {
            logger.debug("No environments were found for the platform::" + platformName);
            //throw new ResourceNotFoundException(ErrorCodes.PLATFORM_NOT_FOUND);
        }

        String response = "cloudBeesAdapter.getAllEnvironmentDetails(applicationId)";
        logger.debug("Response received from CLOUDBEES ::" + response);

        // List<CloudbeesEnvironmentResponseVo> list;
        try {
            // list = null; //new ObjectMapper().readValue(response, new TypeReference<List<CloudbeesEnvironmentResponseVo>>() {});
        } catch (Exception exception) {
            logger.error("Error occurred while parsing the response", exception);
            throw new RuntimeException(exception);
        }
        /*
        return list.stream()
                .map(object -> new EnvironmentResponseVo(object.getName(), object.getKey(), object.getDescription()))
                .collect(Collectors.toList());

         */
        return null;
    }

    @Override
    public EnvironmentResponseVo registerEnvironment(final EnvironmentRequestVo environmentRequestVo) {
        logger.debug("In EnvironmentServiceImpl:: registerEnvironment ::::" + environmentRequestVo);

        String applicationId = "Utility.getApplicationIdFromPlatformName(environmentRequestVo.getPlatformName())";
        if (Strings.isEmpty(applicationId)) {
            logger.debug("No platform found by platformName::" + environmentRequestVo.getPlatformName());
            // throw new ResourceNotFoundException(ErrorCodes.PLATFORM_NOT_FOUND);
        }

        String environmentId = "cloudBeesAdapter.createEnvironment(applicationId, environmentRequestVo)";
        logger.info("Response received from CLOUDBEES ::" + environmentId);

        return new EnvironmentResponseVo(environmentRequestVo.getEnvironmentName(), environmentId, environmentRequestVo.getDescription());
    }

    @Override
    public EnvironmentResponseVo updateEnvironment(EnvironmentRequestVo environmentRequestVo) {
        return null;
    }

    @Override
    public EnvironmentResponseVo deleteEnvironment(final EnvironmentRequestVo environmentRequestVo) {
        logger.debug("In EnvironmentServiceImpl:: deleteEnvironment ::::" + environmentRequestVo);

        String applicationId = "Utility.getApplicationIdFromPlatformName(environmentRequestVo.getPlatformName())";
        if (Strings.isEmpty(applicationId)) {
            logger.info("No platform found by platformName::" + environmentRequestVo.getPlatformName());
            // throw new ResourceNotFoundException(ErrorCodes.PLATFORM_NOT_FOUND);
        }

        String environmentId = "cloudBeesAdapter.deleteEnvironment(applicationId, environmentRequestVo)";
        logger.debug("Response received from CLOUDBEES ::" + environmentId);

        return new EnvironmentResponseVo(environmentRequestVo.getEnvironmentName(), environmentId, environmentRequestVo.getDescription());
    }
}


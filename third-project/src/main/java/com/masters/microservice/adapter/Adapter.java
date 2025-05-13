package com.masters.microservice.adapter;


import com.masters.microservice.request.EnvironmentRequestVo;
import com.masters.microservice.request.PlatformRequestVo;

/**
 * Interface that describes operation that are performed on CloudBees by BHN.
 */
public interface Adapter {


    String createEnvironment(String platformName, EnvironmentRequestVo environmentRequestVo);


    String getAllEnvironmentDetails(String platformId);


    String getAllPlatformDetails();


//String getPlatformByName(String platformName);


    String registerPlatform(PlatformRequestVo platformRequestVo);


    String deleteEnvironment(String applicationId, EnvironmentRequestVo environmentRequestVo);


    String getFlagByName(String applicationId, String environmentName, String flagName);


    String getAllFlagsByApplicationAndEnvironment(String applicationId, String environmentName);


    String createFlag(String applicationId, String flagName);


    String updateFlag(String applicationId, String environmentName, String flagName, Object value);


    String deleteFlag(String applicationId, String flagName);

}

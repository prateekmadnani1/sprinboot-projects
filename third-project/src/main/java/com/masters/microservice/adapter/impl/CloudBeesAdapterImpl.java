package com.masters.microservice.adapter.impl;

import com.masters.microservice.adapter.Adapter;
import com.masters.microservice.request.EnvironmentRequestVo;
import com.masters.microservice.request.PlatformRequestVo;
import org.springframework.stereotype.Component;



/**
 * Implementation of calls to CloudBees.
 */
@Component
class AdapterImpl implements Adapter {
    @Override
    public String createEnvironment(String platformName, EnvironmentRequestVo environmentRequestVo) {
        return "";
    }

    @Override
    public String getAllEnvironmentDetails(String platformId) {
        return "";
    }

    @Override
    public String getAllPlatformDetails() {
        return "";
    }

    @Override
    public String registerPlatform(PlatformRequestVo platformRequestVo) {
        return "";
    }

    @Override
    public String deleteEnvironment(String applicationId, EnvironmentRequestVo environmentRequestVo) {
        return "";
    }

    @Override
    public String getFlagByName(String applicationId, String environmentName, String flagName) {
        return "";
    }

    @Override
    public String getAllFlagsByApplicationAndEnvironment(String applicationId, String environmentName) {
        return "";
    }

    @Override
    public String createFlag(String applicationId, String flagName) {
        return "";
    }

    @Override
    public String updateFlag(String applicationId, String environmentName, String flagName, Object value) {
        return "";
    }

    @Override
    public String deleteFlag(String applicationId, String flagName) {
        return "";
    }
//
//    private static final Logger logger = LoggerFactory.getLogger(CloudbeesAdapterImpl.class);
//
//
//    private final CloudBeesProperties cloudBeesProperties;
//
//
//    private OkHttpClient okHttpClient;
//
//
//    private Map<String, ErrorCodes> errorCodesMap = new HashMap<>();
//
//
//    /**
//     * Initializing errorCode map to use it while throwing BadRequestException.
//     *
//     * @param cloudBeesProperties for Cloudbees specific values
//     */
//    public CloudbeesAdapterImpl(CloudBeesProperties cloudBeesProperties) {
//        this.cloudBeesProperties = cloudBeesProperties;
//        this.okHttpClient = new OkHttpClient();
//        this.errorCodesMap.put("Missing application", ErrorCodes.PLATFORM_NOT_FOUND);
//        this.errorCodesMap.put("Missing environment", ErrorCodes.ENVIRONMENT_NOT_FOUND);
//        this.errorCodesMap.put("Flag not found", ErrorCodes.FLAG_NOT_FOUND);
//        this.errorCodesMap.put("value is not one of the available options", ErrorCodes.FLAG_POSSIBLE_VALUE_ERROR);
//    }
//
//
//    /**
//     * This setter is used for Junit test cases purpose as we cannot mock Final Classes.
//     * So we need to set it externally and mock it.
//     *
//     * @param value as external object provided by Junit test cases.
//     */
//    void setOkHttpClient(OkHttpClient value) {
//        this.okHttpClient = value;
//    }
//
//
//    @Override
//    public String getAllPlatformDetails() {
//        logger.debug("In CloudbeesAdapterImpl:: getAllPlatformDetails ::::");
//        Response response = executeRequestReturnResponse(getBasicRequestBuilder("").get().build());
//        int responseCode = response.code();
//        String responseString = getResponseString(response);
//        if (responseCode == HttpStatus.OK.value()) {
//            return responseString;
//        } else {
//            throw new FeatureFlaggingServiceException(ErrorCodes.GENERAL_ERROR);
//        }
//    }
//
//
//    /*
//    According to BHN TAXONOMY platform name is equal to application name in Cloudbees
//    */
//    @Override
//    public String registerPlatform(PlatformRequestVo platformRequestVo) {
//        logger.debug("In CloudbeesAdapterImpl:: registerPlatform ::::" + platformRequestVo);
//
//
//        CloudbeesPlatformRequestVo cloudbeesPlatformRequestVo = new CloudbeesPlatformRequestVo();
//        cloudbeesPlatformRequestVo.setApplicationName(platformRequestVo.getPlatform().trim());
//
//
//        Response response = executeRequestReturnResponse(getBasicRequestBuilder("")
//                .post(createBodyFromObject(cloudbeesPlatformRequestVo)).build());
//        int responseCode = response.code();
//        String responseString = getResponseString(response);
//        if (responseCode == HttpStatus.OK.value()) {
//            return responseString;
//        } else if (responseCode == HttpStatus.CONFLICT.value()) {
//            throw new BadRequestException(ErrorCodes.PLATFORM_ALREADY_EXISTS);
//        } else {
//            throw new FeatureFlaggingServiceException(ErrorCodes.GENERAL_ERROR);
//        }
//    }
//
//
//    @Override
//    public String createEnvironment(String platformId, EnvironmentRequestVo environmentRequestVo) {
//        logger.info("In CloudbeesAdapterImpl:: createEnvironment ::::" + platformId
//                + ", environmentRequestVo::" + environmentRequestVo);
//
//
//        Response response = executeRequestReturnResponse(getBasicRequestBuilder(platformId + "/environments/key")
//                .put(createBodyFromObject(getCloudbeesEnvironmentRequestVo(environmentRequestVo))).build());
//        int responseCode = response.code();
//        String responseString = getResponseString(response);
//        if (responseCode == HttpStatus.OK.value()) {
//            return responseString;
//        } else if (responseCode == HttpStatus.NOT_FOUND.value()) {
//            throw new BadRequestException(ErrorCodes.PLATFORM_NOT_FOUND);
//        } else if (responseCode == HttpStatus.CONFLICT.value()) {
//            throw new BadRequestException(ErrorCodes.ENVIRONMENT_ALREADY_EXISTS);
//        } else {
//            throw new FeatureFlaggingServiceException(ErrorCodes.GENERAL_ERROR);
//        }
//    }
//
//
//    @Override
//    public String getAllEnvironmentDetails(String platformId) {
//        logger.debug("In CloudbeesAdapterImpl:: getAllEnvironmentDetails ::::" + platformId);
//        Response response = executeRequestReturnResponse(getBasicRequestBuilder(
//                platformId + "/environments").get().build());
//        int responseCode = response.code();
//        String responseString = getResponseString(response);
//        if (responseCode == HttpStatus.OK.value()) {
//            return responseString;
//        } else if (responseCode == HttpStatus.NOT_FOUND.value()) {
//            throw new BadRequestException(ErrorCodes.PLATFORM_NOT_FOUND);
//        } else {
//            throw new FeatureFlaggingServiceException(ErrorCodes.GENERAL_ERROR);
//        }
//    }
//
//
//    @Override
//    public String deleteEnvironment(String applicationId, EnvironmentRequestVo environmentRequestVo) {
//        logger.debug("In CloudbeesAdapterImpl:: deleteEnvironment ::::" + environmentRequestVo);
//        Response response = executeRequestReturnResponse(getBasicRequestBuilder(applicationId
//                + "/environments/" + environmentRequestVo.getEnvironmentName()).delete(null).build());
//        int responseCode = response.code();
//        String responseString = getResponseString(response);
//        if (responseCode == HttpStatus.OK.value()) {
//            return responseString;
//        } else if (responseCode == HttpStatus.NOT_FOUND.value() && responseString.equalsIgnoreCase("Not Found")) {
//            throw new BadRequestException(ErrorCodes.ENVIRONMENT_NOT_FOUND);
//        } else if (responseCode == HttpStatus.NOT_FOUND.value()) {
//            throw new BadRequestException(errorCodesMap.get(responseString));
//        } else {
//            throw new FeatureFlaggingServiceException(ErrorCodes.GENERAL_ERROR);
//        }
//    }
//
//
//
//
//
//
//    @Override
//    public String getFlagByName(String applicationId, String environmentName, String flagName) {
//        logger.debug("In CloudbeesAdapterImpl:: getFlagByName :::: applicationId::" + applicationId
//                + ", environmentName::" + environmentName + ", flagName::" + flagName);
//        Response response = executeRequestReturnResponse(getBasicRequestBuilder(applicationId
//                + "/" + environmentName + "/flags/" + flagName + "?includeFlagStatus=true").get().build());
//        return getFlagResponse(response);
//    }
//
//
//    @Override
//    public String getAllFlagsByApplicationAndEnvironment(String applicationId, String environmentName) {
//        logger.debug("In CloudbeesAdapterImpl:: getAllFlagsByApplicationAndEnvironment :::: applicationId::"
//                + applicationId + ", environmentName::" + environmentName);
//        Response response = executeRequestReturnResponse(getBasicRequestBuilder(applicationId
//                + "/" + environmentName + "/flags").get().build());
//        int responseCode = response.code();
//        String responseString = getResponseString(response);
//        if (responseCode == HttpStatus.OK.value()) {
//            return responseString;
//        } else if (responseCode == HttpStatus.NOT_FOUND.value()) {
//            throw new BadRequestException(errorCodesMap.get(responseString));
//        } else {
//            throw new FeatureFlaggingServiceException(ErrorCodes.GENERAL_ERROR);
//        }
//    }
//
//
//    @Override
//    public String createFlag(String applicationId, String flagName) {
//        logger.debug("In CloudbeesAdapterImpl:: createFlag :::: applicationId::" + applicationId
//                + " , flagName::" + flagName);
//
//
//        CloudbeesFlagRequestVo flagRequestVo = new CloudbeesFlagRequestVo();
//        flagRequestVo.setName(flagName);
//
//
//        return executeCreateFlagRequest(applicationId, flagName, flagRequestVo);
//    }
//
//
//    private String executeCreateFlagRequest(String applicationId, String flagName,
//                                            CloudbeesFlagRequestVo flagRequestVo) {
//        Response response = executeRequestReturnResponse(getBasicRequestBuilder(applicationId + "/flags")
//                .put(createBodyFromObject(flagRequestVo)).build());
//        int responseCode = response.code();
//        String responseString = getResponseString(response);
//        if (responseCode == HttpStatus.OK.value()) {
//            return responseString;
//        } else if (responseCode == HttpStatus.NOT_FOUND.value()) {
//            throw new BadRequestException(errorCodesMap.get(responseString));
//        } else if (responseCode == HttpStatus.CONFLICT.value()) {
//            throw new BadRequestException(ErrorCodes.FLAG_ALREADY_EXISTS);
//        } else {
//            throw new FeatureFlaggingServiceException(ErrorCodes.GENERAL_ERROR);
//        }
//    }
//
//
//    @Override
//    public String updateFlag(String applicationId, String environmentName, String flagName, Object value) {
//        logger.debug("In CloudbeesAdapterImpl:: updateFlag :::: applicationId::" + applicationId
//                + ", environmentName::" + environmentName + " , flagName::" + flagName);
//
//
//        String flagInfo = getFlagByName(applicationId, environmentName, flagName);
//// Parse response. Cheat and convert to boolean. There is an issue on cloudbee side when setting value.
//        try {
//            FlagInfoResponse flagInfoResponse = new ObjectMapper()
//// There is more properties that CloudBees gives back, but we do not need them for now.
//                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
//                    .readValue(flagInfo, FlagInfoResponse.class);
//            if (flagInfoResponse.isBoolean()) {
//// Recast value to boolean so that it is serialized into Json as true instead of "true".
//                value = Boolean.parseBoolean(value.toString());
//            }
//        } catch (JsonProcessingException e) {
//            logger.error("In CloudbeesAdapterImpl:: updateFlag:: Unable to parse flag info response ::::", e);
//            throw new FeatureFlaggingServiceException(ErrorCodes.GENERAL_ERROR);
//        }
//        return getFlagUpdateResponse(applicationId, environmentName, flagName, value);
//    }
//
//
//    private String getFlagUpdateResponse(String applicationId, String environmentName, String flagName, Object value) {
//        Response response = executeRequestReturnResponse(getBasicRequestBuilder(applicationId
//                + "/" + environmentName + "/flags/" + flagName)
//                .patch(createBodyFromObject(
//                        Arrays.asList(
//                                new FlagValueUpdateVo(value),
//                                new FlagValueUpdateVo("/enabled", "true")
//                        )
//                )).build());
//        int responseCode = response.code();
//        String responseString = getResponseString(response);
//        if (responseCode == HttpStatus.OK.value()) {
//            return responseString;
//        } else if (responseCode == HttpStatus.NOT_FOUND.value()) {
//            throw new BadRequestException(errorCodesMap.get(responseString));
//        } else if (responseCode == HttpStatus.INTERNAL_SERVER_ERROR.value()
//                && responseString.equalsIgnoreCase("value is not one of the available options")) {
//            throw new BadRequestException(ErrorCodes.FLAG_POSSIBLE_VALUE_ERROR);
//        } else {
//            throw new FeatureFlaggingServiceException(ErrorCodes.GENERAL_ERROR);
//        }
//    }
//
//
//    @Override
//    public String deleteFlag(String applicationId, String flagName) {
//        logger.debug("In CloudbeesAdapterImpl:: deleteFlag :::: applicationId::" + applicationId
//                + " , flagName::" + flagName);
//        Response response = executeRequestReturnResponse(getBasicRequestBuilder(applicationId + "/flags/" + flagName)
//                .delete(null).build());
//        return getFlagResponse(response);
//    }
//
//
//    /**
//     * Convert object into Json payload as RequestBody object.
//     *
//     * @param payload object to get into Json.
//     * @return instance of RequestBody filled in with object content.
//     */
//    public <T> RequestBody createBodyFromObject(T payload) {
//        MediaType mediaType = MediaType.parse(Constants.CloudBees.APPLICATION_JSON_MEDIA_TYPE);
//        try {
//            String json = new ObjectMapper().writeValueAsString(payload);
//            logger.debug("Serialized Json for request:{}", json);
//            return RequestBody.create(mediaType, json);
//        } catch (JsonProcessingException e) {
//            logger.error("In CloudbeesAdapterImpl:: createBodyFromObject ::::" + e);
//            throw new FeatureFlaggingServiceException(ErrorCodes.GENERAL_ERROR);
//        }
//    }
//
//
//    /**
//     * Execute Rollout request and return result as response object.
//     *
//     * @param request request to execute.
//     * @return full response object.
//     */
//    public Response executeRequestReturnResponse(Request request) {
//        try {
//            logger.debug("Going to HIT CLOUDBEES with Request::{}", request.body());
//            Response response = this.okHttpClient.newCall(request).execute();
//            logger.debug("Response received from CLOUDBEES::{}", response.code());
//            return response;
//        } catch (IOException exception) {
//            logger.error("In CloudbeesAdapterImpl:: executeRequestReturnString ::::", exception);
//            throw new FeatureFlaggingServiceException(ErrorCodes.GENERAL_ERROR);
//        } catch (Exception e) {
//            logger.error("In CloudbeesAdapterImpl:: executeRequestReturnString ::::", e);
//            throw new FeatureFlaggingServiceException(ErrorCodes.GENERAL_ERROR);
//        }
//    }
//
//
//    /**
//     * Get the Request Builder with common properties for all requests set.
//     *
//     * @param urlPostfix URL to append to the end URL
//     * @return instance of builder that caller can further customize.
//     */
//    public Request.Builder getBasicRequestBuilder(String urlPostfix) {
//        return new Request.Builder()
//                .url(cloudBeesProperties.getApiUrl() + urlPostfix)
//                .addHeader(Constants.CloudBees.AUTHORIZATION_HEADER, cloudBeesProperties.getTokenHeaderContent())
//                .addHeader(Constants.CloudBees.ACCEPT_HEADER, Constants.CloudBees.APPLICATION_JSON_MEDIA_TYPE)
//                .addHeader(Constants.CloudBees.CONTENT_TYPE_HEADER, Constants.CloudBees.APPLICATION_JSON_MEDIA_TYPE);
//    }
//
//
//    /**
//     * Get the Response String received from Cloudbees OkHttpClient.
//     *
//     * @param response object received from Cloudbees OkHttpClient.
//     * @return string from Response.
//     */
//    private String getResponseString(Response response) {
//        String responseString;
//        try {
//// This is a stream. It can be read only once.
//            responseString = response.body().string();
//            logger.debug("response received from Cloudbees::" + responseString);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return responseString;
//    }
//
//
//    /**
//     * Get Cloudbees environment request VO by converting EnvironmentRequestVo.
//     *
//     * @param environmentRequestVo received from EnvironmentServiceImpl.
//     * @return newly CloudbeesEnvironmentRequestVo object for Cloudbees call.
//     */
//
//
//    private CloudbeesEnvironmentRequestVo getCloudbeesEnvironmentRequestVo(EnvironmentRequestVo environmentRequestVo) {
//        CloudbeesEnvironmentRequestVo cloudbeesEnvironmentRequestVo = new CloudbeesEnvironmentRequestVo();
//        cloudbeesEnvironmentRequestVo.setName(environmentRequestVo.getEnvironmentName().trim());
//        cloudbeesEnvironmentRequestVo.setDescription(environmentRequestVo.getDescription());
//        return cloudbeesEnvironmentRequestVo;
//    }
//
//
//    private String getFlagResponse(Response response) {
//        int responseCode = response.code();
//        String responseString = getResponseString(response);
//        if (responseCode == HttpStatus.OK.value()) {
//            return responseString;
//        } else if (responseCode == HttpStatus.NOT_FOUND.value()
//                && responseString.equalsIgnoreCase("Not Found")) {
//            throw new BadRequestException(ErrorCodes.FLAG_NOT_FOUND);
//        } else if (responseCode == HttpStatus.NOT_FOUND.value()
//                || responseCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//            throw new BadRequestException(errorCodesMap.get(responseString));
//        } else {
//            throw new FeatureFlaggingServiceException(ErrorCodes.GENERAL_ERROR);
//        }
//    }

}

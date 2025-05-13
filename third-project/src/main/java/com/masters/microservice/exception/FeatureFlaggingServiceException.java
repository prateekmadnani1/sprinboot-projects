package com.masters.microservice.exception;


/**
 * FeatureFlaggingServiceException.
 */
public class FeatureFlaggingServiceException extends RuntimeException {


    private int errorCode;


    private String description;


    public FeatureFlaggingServiceException(ErrorCodes errorCodes) {
        this.errorCode = errorCodes.getCode();
        this.description = errorCodes.getDescription();
    }


    public int getErrorCode() {
        return errorCode;
    }


    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "FeatureFlaggingServiceException{"
                + "errorCode=" + errorCode + ", description='" + description + '\'' + '}';
    }


}

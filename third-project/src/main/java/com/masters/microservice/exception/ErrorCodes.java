package com.masters.microservice.exception;


/**
 * ErrorCodes For Exception Handling.
 */
public enum ErrorCodes {


    PLATFORM_NOT_FOUND(0, "Platform not found by given name."),
    ENVIRONMENT_NOT_FOUND(1, "Environment not found by given name."),


    ENVIRONMENTS_NOT_FOUND(2, "No Environments created for given platform."),
    GENERAL_ERROR(3, "Some error occurred at backend, please try again after some time"),


    PLATFORM_ALREADY_EXISTS(4, "Platform already exists"),


    ENVIRONMENT_ALREADY_EXISTS(5, "Environment already exists"),


    FLAG_NOT_FOUND(6, "Flag not found by given name."),


    FLAG_ALREADY_EXISTS(7, "Flag already exists"),


    FLAG_POSSIBLE_VALUE_ERROR(8, "Provided value is not one of the possible values for flag");


    private final int code;
    private final String description;


    ErrorCodes(int code, String description) {
        this.code = code;
        this.description = description;
    }


    public String getDescription() {
        return description;
    }


    public int getCode() {
        return code;
    }


    @Override
    public String toString() {
        return code + ": " + description;
    }
}

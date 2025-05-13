package com.masters.microservice.exception;


/**
 * The BadRequestException class represents an exception that occurs when a request made to the server
 * is not properly formed or contains invalid data.
 * This exception is handled in {@link GlobalExceptionHandler} Class.
 */
public class BadRequestException extends RuntimeException {


    private int errorCode;


    private String description;


    public BadRequestException(ErrorCodes errorCodes) {
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
        return "BadRequestException{"
                + "errorCode=" + errorCode + ", description='" + description + '\'' + '}';
    }


}

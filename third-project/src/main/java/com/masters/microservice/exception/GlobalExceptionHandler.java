package com.masters.microservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * Method to handle resource not found exception.
     *
     * @param exception ResourceNotFoundException.
     * @return error response with HTTP code 404.
     */
    /*
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleNoSuchElementFoundException(ResourceNotFoundException exception,
                                                                    WebRequest request) {
        logger.error("Failed to find the requested element", exception);
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode(), exception.getDescription());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    */

    /**
     * Method to handle internal server exception.
     *
     * @param exception FeatureFlaggingServiceException.
     * @return error response with HTTP code 500.
     */
    /*
    @ExceptionHandler(FeatureFlaggingServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleFeatureFlaggingServiceException(FeatureFlaggingServiceException exception,
                                                                        WebRequest request) {
        logger.error("Failed to serve the request", exception);
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode(), exception.getDescription());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    */

    /**
     * Method to handle bad request exception.
     *
     * @param exception BadRequestException.
     * @return error response with HTTP code 400.
     */
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException exception,
                                                            WebRequest request) {
        logger.error("Failed to serve the request", exception);
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode(), exception.getDescription());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    /**
     * Method to handle invalid method argument request exception.
     *
     * @param exception MethodArgumentNotValidException.
     * @return error response with HTTP code 400.
     */
    /*
    @Override
    @ResponseStatus
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        String errorMessage = exception.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        List<String> validationList = exception.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getDefaultMessage()).collect(Collectors.toList());
        logger.error("Validation error list : " + validationList);
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), errorMessage);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    */

    /**
     * Method to handle unhandled exception.
     * Catching and handling ConstraintViolationException.
     *
     * @param exception exception to handle.
     * @param request incoming web request.
     * @return ResponseEntity filled in with error information.
     */
    /*
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus
    protected ResponseEntity<Object> handleConstraintViolationException(
            ConstraintViolationException exception, WebRequest request) {


        logger.error("Failed to serve the request", exception);
        StringBuilder sb = new StringBuilder();
        for (ConstraintViolation constraintViolation : exception.getConstraintViolations()) {
            sb.append(constraintViolation.getConstraintDescriptor() == null ? "" :
                    (constraintViolation.getConstraintDescriptor().getAttributes() == null ? "" :
                            (constraintViolation.getConstraintDescriptor().getAttributes().keySet().contains("message")
                                    ? constraintViolation.getConstraintDescriptor().getAttributes()
                                    .get("message") : "")));
        }
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), sb.toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    */
    /**
     * Method to handle all exceptions. Essentially a catch-all.
     *
     * @param exception Exception.
     * @return error response with HTTP code 500.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception exception) {
        logger.error("Generic error happened", exception);
        ErrorResponse errorResponse = new ErrorResponse(500, "Internal Server Error");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


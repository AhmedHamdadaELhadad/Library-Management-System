package com.maids.zohorecruit.Library.Management.System.ExceptionHandler;


    // Custom Expection
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

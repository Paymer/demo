package com.demo.demo.model;

import lombok.Data;

@Data
public class ResourceNotFoundException extends Exception{

    private String message;

    public ResourceNotFoundException (String message){
        this.message = message;
    }

}

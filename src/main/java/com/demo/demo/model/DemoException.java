package com.demo.demo.model;

import lombok.Data;

@Data
public class DemoException extends Exception{

    private String message;

}

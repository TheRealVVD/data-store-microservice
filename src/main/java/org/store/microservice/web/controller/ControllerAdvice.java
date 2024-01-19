package org.store.microservice.web.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.store.microservice.model.exception.SensorNotFoundException;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(SensorNotFoundException.class)
    public String sensorNotFound(SensorNotFoundException e) {
        return "Sensor not found";
    }

    @ExceptionHandler
    public String server(Exception e) {
        e.printStackTrace();
        return "Something happened on server.";
    }

}

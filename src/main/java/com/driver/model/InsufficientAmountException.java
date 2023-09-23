package com.driver.model;

import org.apache.logging.log4j.message.Message;

public class InsufficientAmountException extends RuntimeException {
    public InsufficientAmountException(String message){
        super(message);
    }
}

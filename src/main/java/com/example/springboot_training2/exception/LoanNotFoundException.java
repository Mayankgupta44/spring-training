package com.example.springboot_training2.exception;

public class LoanNotFoundException extends RuntimeException{
    public LoanNotFoundException(String message){ super(message); }
}

package com.prueba.ms_banking.infraestructure.exception;

public class PersonaAlreadyExistsException extends RuntimeException{

    public PersonaAlreadyExistsException() {
        super();
        //super("example personalized  message");
    }
}
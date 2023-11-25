package com.project.NiralNetwork.NiralNetwork.Exceptions;


public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(){
        super("Employee Not found !!");
    }

    public EmployeeNotFoundException(String message){
        super(message);
    }
}

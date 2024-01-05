package com.crudoperations.database_operations.Exceptions;

public class DuplicateStudentException extends Exception{
    public DuplicateStudentException(String mgs){
        super(mgs);
    }
}

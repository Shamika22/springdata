package com.crudoperations.database_operations.Exceptions;

import org.springframework.dao.DataAccessException;

public class DatabaseAccessException extends DataAccessException {
    public DatabaseAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }

}

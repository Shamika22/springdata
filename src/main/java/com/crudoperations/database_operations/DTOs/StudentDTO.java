package com.crudoperations.database_operations.DTOs;

import java.util.List;

public record StudentDTO (String firstName , String lastName , String emailId , String photoURL, List<SiblingData> siblingList) {
    public record SiblingData(String name){

    }
}

package com.crudoperations.database_operations.Controllers;


import com.crudoperations.database_operations.DTOs.EmailDTO;
import com.crudoperations.database_operations.DTOs.StudentDTO;
import com.crudoperations.database_operations.Entities.Student;
import com.crudoperations.database_operations.Exceptions.DuplicateStudentException;
import com.crudoperations.database_operations.Servises.StudentServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/")
public class MainController {

    @Autowired
    private StudentServise studentServer;

    @GetMapping(path = "get")
    public ResponseEntity<String> getStart(){
        return ResponseEntity.ok("First API");
    }

    @PostMapping("add")
    public ResponseEntity<?> addStudent(@RequestBody StudentDTO student){
        try{
            studentServer.AddStudent(student);
            return ResponseEntity.ok().body("OK");
        }
        catch (DuplicateStudentException e){
            return  ResponseEntity.badRequest().body("Duplicate Entry");
        }
        catch (DataAccessException e1){
            return  ResponseEntity.badRequest().body(e1.getMessage());
        }
        catch (Exception e2){
            return  ResponseEntity.badRequest().body(e2.getMessage());
        }


    }

    @PostMapping(path="find")
    public ResponseEntity<List<Student>> findStudent(@RequestBody EmailDTO email){
        return ResponseEntity.ok(studentServer.FindStudentByEmail(email.email()));
    }
}

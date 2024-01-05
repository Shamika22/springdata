package com.crudoperations.database_operations.Servises;

import com.crudoperations.database_operations.DTOs.StudentDTO;
import com.crudoperations.database_operations.Entities.Photo;
import com.crudoperations.database_operations.Entities.Siblings;
import com.crudoperations.database_operations.Entities.Student;
import com.crudoperations.database_operations.Exceptions.DatabaseAccessException;
import com.crudoperations.database_operations.Exceptions.DuplicateStudentException;
import com.crudoperations.database_operations.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServise {
    @Autowired
    private StudentRepository studentTable;

    public List<Student> FindStudentByEmail(String email){
        List<Student> theStudentList = studentTable.findStudentByEmailid(email);
        Student theStudent = studentTable.findByEmailid(email);

        System.out.println(theStudentList);
        System.out.println(theStudent);

        return theStudentList;
    }
    @Transactional
    public void AddStudent(StudentDTO student) throws DuplicateStudentException {
        Student studentCheck = studentTable.findByEmailid(student.emailId());
        if(studentCheck == null){

            List<Siblings> theSiblingList =  new ArrayList<>();

            Photo thePhoto = new Photo(student.photoURL());
            for (StudentDTO.SiblingData data:
            student.siblingList()) {
                Siblings theSibling = new Siblings(data.name());
                theSiblingList.add(theSibling);
            }


            Student theStudent = new Student();
            theStudent.setEmailid(student.emailId());
            theStudent.setFirstName(student.firstName());
            theStudent.setLastName(student.lastName());
            theStudent.setPhoto(thePhoto);
            theStudent.setTheSiblingList(theSiblingList);




            try{
                studentTable.save(theStudent);
            }
            catch (DataAccessException ex){
                throw new DatabaseAccessException("Database Error : Addition student",ex);
            }


        }else{
            throw new DuplicateStudentException("Duplicate Student entry");
        }

    }
}

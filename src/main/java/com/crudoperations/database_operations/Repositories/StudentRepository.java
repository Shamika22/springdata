package com.crudoperations.database_operations.Repositories;

import com.crudoperations.database_operations.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findStudentByEmailid(String emailid);
    Student findByEmailid(String emaiid);


}

package com.crudoperations.database_operations.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (
        name = "student_table",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_emailid",
                columnNames = "email_id"
        )
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.UUID,
            generator = "student_sequence"
    )
    private Long studentid;
    @Column(
        name = "first_name", nullable = false
    )
    private String firstName;
    @Column(
            name = "last_name", nullable = false
    )
    private String lastName;
    @Column(
            name = "email_id", nullable = false
    )
    private String emailid;

    @OneToOne(cascade = CascadeType.ALL)
    private Photo photo;

    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Siblings> theSiblingList = new ArrayList<Siblings>();

    public Student(String firstName, String lastName, String emailid, Photo photo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailid = emailid;
        this.photo = photo;
    }

    public Student() {

    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public List<Siblings> getTheSiblingList() {
        return theSiblingList;
    }

    public void setTheSiblingList(List<Siblings> theSiblingList) {
        this.theSiblingList = theSiblingList;
    }

    @Override
    public String toString() {
        return this.firstName+this.lastName+this.emailid;
    }



}

package com.crudoperations.database_operations.Entities;

import jakarta.persistence.*;

@Entity
@Table(
        name = "sibling_table"
)
public class Siblings {

    @Id
    private int id;
    @Column(nullable = false)
    private String name;


    @ManyToOne()
    private Student student;

    public Siblings(String name) {
        this.name = name;
    }



    public Siblings() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

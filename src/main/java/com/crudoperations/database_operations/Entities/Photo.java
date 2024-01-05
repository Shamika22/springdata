package com.crudoperations.database_operations.Entities;

import jakarta.persistence.*;

@Entity
@Table(
        name = "photo_table"
)
public class Photo {

    @Id
    @SequenceGenerator(
            name = "photo_id_generator",
            sequenceName = "photo_id_generator"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "photo_id_generator"
    )
    private int photoId;
    @Column(nullable = false)
    private String photoURL;

    public Photo(String photoURL) {
        this.photoURL = photoURL;
    }

    public Photo() {

    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }
}

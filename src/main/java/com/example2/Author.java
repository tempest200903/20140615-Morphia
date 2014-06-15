package com.example2;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class Author {

    @Id
    private ObjectId id;

    private String username;
    private String fullName;
    private String emailAddress;

    // optional getters and setters
}

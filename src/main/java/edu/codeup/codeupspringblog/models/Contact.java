package edu.codeup.codeupspringblog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Collections;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;

    public Contact() {

    }

    public Contact(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

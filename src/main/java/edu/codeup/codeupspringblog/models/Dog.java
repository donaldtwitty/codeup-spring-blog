package edu.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.Getter;
@Entity
@Table(name = "dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) UNSIGNED", nullable = false)
    private long id;

    @Column(name = "age")
    private int age;

    @Column(name = "name")
    private String name;

    @Column(name = "reside_state", length = 2)
    private String resideState;

    public Dog() {
    }

    public Dog(long id, int age, String name, String resideState) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setResideState(String resideState) {
        this.resideState = resideState;
    }
}



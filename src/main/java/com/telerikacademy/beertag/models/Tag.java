package com.telerikacademy.beertag.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Tags")
public class Tag {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TagId")
    private int id;

    @NotNull
    @Column(name = "Name", unique = true, length = 10)
    private String name;

    public Tag() {
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

package com.springboot.proyecto.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RevengePlan {
    @Id
    private Long id;

    public RevengePlan(long id){
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
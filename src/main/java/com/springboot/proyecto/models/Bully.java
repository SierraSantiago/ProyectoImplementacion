package com.springboot.proyecto.models;

import jakarta.persistence.*;

@Entity
public class Bully {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nickname;

    @Enumerated(EnumType.STRING)
    private HighSchoolRole highSchoolRole;

    private String bullyingReason;
    private int levelOfAnnoyance;

    @ManyToOne
    @JoinColumn(name = "clique_id")
    private Clique clique;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public HighSchoolRole getHighSchoolRole() {
        return highSchoolRole;
    }

    public void setHighSchoolRole(HighSchoolRole highSchoolRole) {
        this.highSchoolRole = highSchoolRole;
    }

    public String getBullyingReason() {
        return bullyingReason;
    }

    public void setBullyingReason(String bullyingReason) {
        this.bullyingReason = bullyingReason;
    }

    public int getLevelOfAnnoyance() {
        return levelOfAnnoyance;
    }

    public void setLevelOfAnnoyance(int levelOfAnnoyance) {
        this.levelOfAnnoyance = levelOfAnnoyance;
    }

    public Clique getClique() {
        return clique;
    }

    public void setClique(Clique clique) {
        this.clique = clique;
    }
}

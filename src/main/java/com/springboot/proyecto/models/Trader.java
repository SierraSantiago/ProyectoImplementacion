package com.springboot.proyecto.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Trader")
public class Trader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "revenge_plan_id")
    private RevengePlan revengePlan;

    @Enumerated(EnumType.STRING)
    private TraderType type;

    private String url;

    private String caption;

    // Constructores
    public Trader() {}

    public Trader(Long id, RevengePlan revengePlan, TraderType type, String url, String caption) {
        this.id = id;
        this.revengePlan = revengePlan;
        this.type = type;
        this.url = url;
        this.caption = caption;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RevengePlan getRevengePlan() {
        return revengePlan;
    }

    public void setRevengePlan(RevengePlan revengePlan) {
        this.revengePlan = revengePlan;
    }

    public TraderType getType() {
        return type;
    }

    public void setType(TraderType type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}

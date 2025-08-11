package com.springboot.proyecto.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="revengePlan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RevengePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private boolean isExecuted;

    @Column
    private SuccessLevel successLevel;

    @Column
    @CreationTimestamp
    private LocalDate datePlanned;

    @OneToMany(mappedBy = "revenge", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Media> media;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Bully bully;

    public RevengePlan(long id){
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
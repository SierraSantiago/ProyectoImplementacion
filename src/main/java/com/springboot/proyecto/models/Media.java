package com.springboot.proyecto.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "media")
@Data
public class Media {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String url;

  @Column
  private String caption;

  @Column
  private MediaType media;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "revenge_id", nullable = false)
  @JsonIgnore
  private RevengePlan revengePlan;


}

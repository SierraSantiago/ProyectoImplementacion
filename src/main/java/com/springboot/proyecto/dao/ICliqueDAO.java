package com.springboot.proyecto.dao;

import com.springboot.proyecto.models.Clique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICliqueDAO extends JpaRepository<Clique, Long> {
    Optional<Clique> findCliqueByName(String name);
}
package com.springboot.proyecto.services;

import com.springboot.proyecto.dto.CliqueDTO;
import com.springboot.proyecto.models.Clique;

import java.util.List;
import java.util.Optional;

public interface IServiceClique {
    List<CliqueDTO> getCliques();
    Clique addClique(CliqueDTO c);
    Optional<Clique> removeClique(Long id);
    Optional<Clique> getCliqueById(Long id);
    Optional<Clique> getByName(String name);
}

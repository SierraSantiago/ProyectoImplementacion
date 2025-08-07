package com.springboot.proyecto.services;


import com.springboot.proyecto.dto.BullyDTO;
import com.springboot.proyecto.models.Bully;

import java.util.List;
import java.util.Optional;

public interface IServiceBully {
    List<BullyDTO> getBullies();
    Bully addBully(BullyDTO bullyDTO);
    Optional<Bully> getBullyById(Long id);
    Optional<Bully> getByName(String name);
    Optional<Bully> removeBully(Long id);
}
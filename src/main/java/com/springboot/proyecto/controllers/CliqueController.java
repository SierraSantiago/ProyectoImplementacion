package com.springboot.proyecto.controllers;

import com.springboot.proyecto.dto.CliqueDTO;
import com.springboot.proyecto.models.Clique;
import com.springboot.proyecto.services.IServiceClique;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliques")
public class CliqueController {

    @Autowired
    private IServiceClique serviceClique;

    @GetMapping
    public List<CliqueDTO> getAllCliques() {
        return serviceClique.getCliques();
    }

    @GetMapping("/{id}")
    public Optional<Clique> getCliqueById(@PathVariable Long id) {
        return serviceClique.getCliqueById(id);
    }

    @PostMapping
    public Clique addClique(@RequestBody @Valid CliqueDTO cliqueDTO) {
        return serviceClique.addClique(cliqueDTO);
    }

    @DeleteMapping("/{id}")
    public Optional<Clique> deleteClique(@PathVariable Long id) {
        return serviceClique.removeClique(id);
    }
}

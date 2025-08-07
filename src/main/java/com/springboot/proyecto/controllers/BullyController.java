package com.springboot.proyecto.controllers;

import com.springboot.proyecto.dto.BullyDTO;
import com.springboot.proyecto.models.Bully;
import com.springboot.proyecto.services.IServiceBully;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bullies")
public class BullyController {

    @Autowired
    private IServiceBully bullyService;

    @GetMapping
    public List<BullyDTO> getBullies() {
        return bullyService.getBullies();
    }

    @GetMapping("/{id}")
    public Optional<Bully> getBullyById(@PathVariable Long id) {
        return bullyService.getBullyById(id);
    }

    @PostMapping
    public Bully addBully(@RequestBody @Valid BullyDTO bullyDTO) {
        return bullyService.addBully(bullyDTO);
    }

    @DeleteMapping("/{id}")
    public Optional<Bully> deleteBully(@PathVariable Long id) {
        return bullyService.removeBully(id);
    }
}

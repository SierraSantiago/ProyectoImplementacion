package com.springboot.proyecto.controllers;

import com.springboot.proyecto.dto.TraderDTO;
import com.springboot.proyecto.models.Trader;
import com.springboot.proyecto.services.IServiceTrader;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/traders")
public class TraderController {

    @Autowired
    private IServiceTrader serviceTrader;

    @GetMapping
    public List<TraderDTO> getAllTraders() {
        return serviceTrader.getTraders();
    }

    @GetMapping("/{id}")
    public Optional<Trader> getTraderById(@PathVariable Long id) {
        return serviceTrader.getTraderById(id);
    }

    @PostMapping
    public Trader addTrader(@RequestBody @Valid TraderDTO dto) {
        return serviceTrader.addTrader(dto);
    }

    @DeleteMapping("/{id}")
    public Optional<Trader> deleteTrader(@PathVariable Long id) {
        return serviceTrader.removeTrader(id);
    }
}

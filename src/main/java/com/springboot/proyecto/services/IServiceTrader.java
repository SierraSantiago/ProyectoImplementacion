package com.springboot.proyecto.services;

import com.springboot.proyecto.dto.TraderDTO;
import com.springboot.proyecto.models.Trader;

import java.util.List;
import java.util.Optional;

public interface IServiceTrader {
    List<TraderDTO> getTraders();
    Trader addTrader(TraderDTO dto);
    Optional<Trader> removeTrader(Long id);
    Optional<Trader> getTraderById(Long id);
}

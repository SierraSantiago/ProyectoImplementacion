package com.springboot.proyecto.dao;

import com.springboot.proyecto.models.Trader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITraderDAO extends JpaRepository<Trader, Long> {
}

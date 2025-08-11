package com.springboot.proyecto.services;

import com.springboot.proyecto.dto.RevengeDTO;
import com.springboot.proyecto.models.RevengePlan;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface IServiceRevengePlan {

  RevengePlan createForBully(Long bullyId, RevengeDTO dto);
  RevengePlan schedule(Long planId, LocalDate datePlanned);
  RevengePlan markExecuted(Long planId, boolean executed);
  @Transactional
  List<RevengePlan> listByBully(Long bullyId);
}

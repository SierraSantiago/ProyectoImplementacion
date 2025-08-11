package com.springboot.proyecto.services;

import com.springboot.proyecto.dao.IBullyDAO;
import com.springboot.proyecto.dao.IRevengePlanDAO;
import com.springboot.proyecto.dto.RevengeDTO;
import com.springboot.proyecto.models.Bully;
import com.springboot.proyecto.models.RevengePlan;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Transactional
public class ServiceRevengePlan implements IServiceRevengePlan{

  private final IRevengePlanDAO planDao;
  private final IBullyDAO bullyDao;

  @Override
  public RevengePlan createForBully(Long bullyId, RevengeDTO dto) {
    Bully bully = bullyDao.findById(bullyId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mediano no encontrado"));

    RevengePlan plan = new RevengePlan();
    plan.setTitle(dto.title());
    plan.setDescription(dto.description());
    plan.setBully(bully);
    plan.setExecuted(false);
    return planDao.save(plan);
  }

  @Override
  public RevengePlan schedule(Long planId, LocalDate datePlanned) {
    RevengePlan plan = planDao.findById(planId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mediano no encontrado"));
    plan.setDatePlanned(datePlanned);

    return plan;
  }

  @Override
  public RevengePlan markExecuted(Long planId, boolean executed) {
    RevengePlan plan = planDao.findById(planId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mediano no encontrado"));
    plan.setExecuted(executed);
    return plan;
  }

  @Override
  @Transactional
  public List<RevengePlan> listByBully(Long bullyId) {
    return planDao.findByBullyId(bullyId);
  }
}

package com.springboot.proyecto.controllers;

import com.springboot.proyecto.dto.RevengeDTO;
import com.springboot.proyecto.models.RevengePlan;
import com.springboot.proyecto.services.IServiceRevengePlan;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/plans")
public class RevengePlanController {

  private final IServiceRevengePlan service;

  @PostMapping("bullies/{bullyId}")
  public ResponseEntity<RevengePlan> createForBully(
    @PathVariable Long bullyId,
        @Valid @RequestBody RevengeDTO dto
  ) {
    return ResponseEntity.status(HttpStatus.CREATED).body(
        service.createForBully(bullyId, dto)
    );
  }

  @PutMapping("/plans/{planId}/schedule")
  public ResponseEntity<RevengePlan> schedule(
      @PathVariable Long planId,
      @RequestBody @Valid LocalDate date
  ) {
    return ResponseEntity.ok(service.schedule(planId, date));
  }

  @GetMapping("/bullies/{bullyId}/plans")
  public ResponseEntity<List<RevengePlan>> listByBully(@PathVariable Long bullyId) {
    return ResponseEntity.ok(service.listByBully(bullyId));
  }

}

package com.springboot.proyecto.controllers;


import com.springboot.proyecto.dto.MediaDTO;
import com.springboot.proyecto.models.Media;
import com.springboot.proyecto.services.IMediaService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/plans/{planId}/media")
public class MediaController {

  private final IMediaService service;

  @PostMapping
  public ResponseEntity<Media> addToPlan(
      @PathVariable Long planId,
      @Valid @RequestBody MediaDTO dto
  ) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.addToPlan(planId, dto));
  }

  @PostMapping("/items")
  public ResponseEntity<List<Media>> addManyToPlan(
      @PathVariable Long planId,
      @Valid @RequestBody List<@Valid MediaDTO> items
  ) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.addManyToPlan(planId, items));
  }

  @GetMapping
  public ResponseEntity<List<Media>> listByPlan(@PathVariable Long planId) {
    return ResponseEntity.ok(service.listByPlan(planId));
  }


}

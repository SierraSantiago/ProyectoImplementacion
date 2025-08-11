package com.springboot.proyecto.controllers;

import com.springboot.proyecto.dto.MoodTrackerDTO;
import com.springboot.proyecto.models.MoodTracker;
import com.springboot.proyecto.services.IMoodTrackerService;
import jakarta.validation.Valid;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/moods")
public class MoodTrackerController {

  private final IMoodTrackerService service;

  @PostMapping
  public ResponseEntity<MoodTracker> add(@Valid @RequestBody MoodTrackerDTO dto) {
    var created = service.add(dto);
    return ResponseEntity.status(201).body(created);
  }

  @GetMapping("/{id}")
  public ResponseEntity<MoodTracker> get(@PathVariable Long id) {
    Optional<MoodTracker> opt = service.get(id);
    return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }
}

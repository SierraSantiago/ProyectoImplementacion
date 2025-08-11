package com.springboot.proyecto.services;

import com.springboot.proyecto.dto.MoodTrackerDTO;
import com.springboot.proyecto.models.MoodTracker;
import java.util.Optional;

public interface IMoodTrackerService {
  MoodTracker add(MoodTrackerDTO dto);
  Optional<MoodTracker> get(Long id);

}

package com.springboot.proyecto.services;

import com.springboot.proyecto.dao.IMoodTrackerDAO;
import com.springboot.proyecto.dto.MoodTrackerDTO;
import com.springboot.proyecto.models.MoodTracker;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ServiceMoodTracker implements  IMoodTrackerService {

  private final IMoodTrackerDAO moodDao;

  @Override
  public MoodTracker add(MoodTrackerDTO dto) {

    int level = dto.moodLevel();

    MoodTracker e = new MoodTracker();
    e.setDate(dto.date() != null ? dto.date() : LocalDate.now());
    e.setMoodLevel(level);
    e.setNote(dto.note());
    return moodDao.save(e);
  }

  @Override
  @Transactional
  public Optional<MoodTracker> get(Long id) {
    return moodDao.findById(id);
  }

}

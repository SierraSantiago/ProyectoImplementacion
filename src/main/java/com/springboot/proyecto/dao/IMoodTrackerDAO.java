package com.springboot.proyecto.dao;

import com.springboot.proyecto.models.MoodTracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMoodTrackerDAO extends JpaRepository<MoodTracker, Long> {

}

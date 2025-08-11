package com.springboot.proyecto.dao;

import com.springboot.proyecto.models.Media;
import com.springboot.proyecto.models.RevengePlan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRevengePlanDAO extends JpaRepository<RevengePlan, Long> {

  List<RevengePlan> findByBullyId(Long bullyId);
}

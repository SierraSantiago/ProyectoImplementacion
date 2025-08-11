package com.springboot.proyecto.dao;

import com.springboot.proyecto.models.Media;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMediaDAO extends JpaRepository<Media, Long> {


  List<Media> findByRevengePlanId(Long revengeId);
}

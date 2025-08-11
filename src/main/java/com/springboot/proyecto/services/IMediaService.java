package com.springboot.proyecto.services;

import com.springboot.proyecto.dto.MediaDTO;
import com.springboot.proyecto.models.Media;
import java.util.List;

public interface IMediaService {
  Media addToPlan(Long planId, MediaDTO dto);
  List<Media> addManyToPlan(Long planId, List<MediaDTO> items);
  List<Media> listByPlan(Long planId);
}

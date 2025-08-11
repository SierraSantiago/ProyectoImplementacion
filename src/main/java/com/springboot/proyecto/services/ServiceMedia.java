package com.springboot.proyecto.services;

import com.springboot.proyecto.dao.IMediaDAO;
import com.springboot.proyecto.dao.IRevengePlanDAO;
import com.springboot.proyecto.dto.MediaDTO;
import com.springboot.proyecto.models.Media;
import com.springboot.proyecto.models.RevengePlan;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Transactional
public class ServiceMedia implements  IMediaService{

  private final IMediaDAO mediaDao;
  private final IRevengePlanDAO planDao;

  @Override
  public Media addToPlan(Long planId, MediaDTO dto) {
    RevengePlan plan = planDao.findById(planId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mediano no encontrado"));

    Media m = new Media();
    m.setRevengePlan(plan);
    m.setUrl(dto.url());
    m.setCaption(dto.caption());
    return mediaDao.save(m);
  }

  @Override
  public List<Media> addManyToPlan(Long planId, List<MediaDTO> items) {
    RevengePlan plan = planDao.findById(planId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mediano no encontrado"));

    List<Media> medias = items.stream().map(dto -> {

      Media m = new Media();
      m.setRevengePlan(plan);
      m.setUrl(dto.url());
      m.setCaption(dto.caption());
      return m;
    }).toList();

    return mediaDao.saveAll(medias);
  }

  @Override
  @Transactional(Transactional.TxType.SUPPORTS)
  public List<Media> listByPlan(Long planId) {
    return mediaDao.findByRevengePlanId(planId);
  }

}

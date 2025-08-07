package com.springboot.proyecto.services;

import com.springboot.proyecto.dao.IBullyDAO;
import com.springboot.proyecto.dao.ICliqueDAO;
import com.springboot.proyecto.dto.BullyDTO;
import com.springboot.proyecto.models.Bully;
import com.springboot.proyecto.models.Clique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceBully implements IServiceBully {

    @Autowired
    private IBullyDAO bullyDao;

    @Autowired
    private ICliqueDAO cliqueDao;

    @Override
    public List<BullyDTO> getBullies() {
        return bullyDao.findAll().stream().map(
                bully -> new BullyDTO(
                        bully.getName(),
                        bully.getNickname(),
                        bully.getHighSchoolRole(),
                        bully.getBullyingReason(),
                        bully.getLevelOfAnnoyance(),
                        bully.getClique() != null ? bully.getClique().getId() : null
                )
        ).toList();
    }

    @Override
    public Bully addBully(BullyDTO dto) {
        Bully bully = new Bully();
        bully.setName(dto.name());
        bully.setNickname(dto.nickname());
        bully.setHighSchoolRole(dto.highSchoolRole());
        bully.setBullyingReason(dto.bullyingReason());
        bully.setLevelOfAnnoyance(dto.levelOfAnnoyance());

        // Buscar el Clique por ID
        Clique clique = cliqueDao.findById(dto.cliqueId())
                .orElseThrow(() -> new RuntimeException("Clique no encontrado con ID: " + dto.cliqueId()));
        bully.setClique(clique);

        return bullyDao.save(bully);
    }

    @Override
    public Optional<Bully> getBullyById(Long id) {
        return bullyDao.findById(id);
    }

    @Override
    public Optional<Bully> getByName(String name) {
        return bullyDao.findBullyByName(name);
    }

    @Override
    public Optional<Bully> removeBully(Long id) {
        Optional<Bully> bully = bullyDao.findById(id);
        bully.ifPresent(b -> bullyDao.deleteById(id));
        return bully;
    }
}

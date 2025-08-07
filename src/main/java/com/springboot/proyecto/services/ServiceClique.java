package com.springboot.proyecto.services;

import com.springboot.proyecto.dao.ICliqueDAO;
import com.springboot.proyecto.dto.CliqueDTO;
import com.springboot.proyecto.models.Clique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceClique implements IServiceClique {

    @Autowired
    private ICliqueDAO cliqueDao;

    @Override
    public List<CliqueDTO> getCliques() {
        return cliqueDao.findAll().stream().map(
                clique -> new CliqueDTO(clique.getName(), clique.getDescription())
        ).toList();
    }

    @Override
    public Clique addClique(CliqueDTO c) {
        Clique clique = new Clique();
        clique.setName(c.name());
        clique.setDescription(c.description());


        return cliqueDao.save(clique);
    }

    @Override
    public Optional<Clique> removeClique(Long id) {
        Optional<Clique> clique = cliqueDao.findById(id);
        clique.ifPresent(cliqueDao::delete);
        return clique;
    }

    @Override
    public Optional<Clique> getCliqueById(Long id) {
        return cliqueDao.findById(id);
    }

    @Override
    public Optional<Clique> getByName(String name) {
        return cliqueDao.findCliqueByName(name);
    }
}

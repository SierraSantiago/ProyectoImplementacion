package com.springboot.proyecto.services;

import com.springboot.proyecto.dao.IRevengePlanDAO;
import com.springboot.proyecto.dao.ITraderDAO;
import com.springboot.proyecto.dto.TraderDTO;
import com.springboot.proyecto.models.RevengePlan;
import com.springboot.proyecto.models.Trader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTrader implements IServiceTrader {

    @Autowired
    private ITraderDAO traderDao;

    @Autowired
    private IRevengePlanDAO revengePlanDao;

    @Override
    public List<TraderDTO> getTraders() {
        return traderDao.findAll().stream().map(
                trader -> new TraderDTO(
                        trader.getType(),
                        trader.getUrl(),
                        trader.getCaption(),
                        trader.getRevengePlan().getId()
                )
        ).toList();
    }

    @Override
    public Trader addTrader(TraderDTO dto) {
        Optional<RevengePlan> revengePlan = revengePlanDao.findById(dto.revengePlanId());

        if (revengePlan.isEmpty()) {
            throw new RuntimeException("Revenge plan no encontrado");
        }

        Trader trader = new Trader();
        trader.setType(dto.type());
        trader.setUrl(dto.url());
        trader.setCaption(dto.caption());
        trader.setRevengePlan(revengePlan.get());

        return traderDao.save(trader);
    }

    @Override
    public Optional<Trader> removeTrader(Long id) {
        Optional<Trader> trader = traderDao.findById(id);
        trader.ifPresent(traderDao::delete);
        return trader;
    }

    @Override
    public Optional<Trader> getTraderById(Long id) {
        return traderDao.findById(id);
    }
}

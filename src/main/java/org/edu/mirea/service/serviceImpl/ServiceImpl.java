package org.edu.mirea.service.serviceImpl;

import org.edu.mirea.dao.Dao;
import org.edu.mirea.entity.Accident;
import org.edu.mirea.mapper.Mapper;
import org.edu.mirea.webmodel.output.WebAccidents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.edu.mirea.service.Service;

import java.util.Calendar;
import java.util.List;

/**
 * Created by mr.balalykin on 13.12.2018.
 */

@Component
public class ServiceImpl implements Service {
    @Autowired
    private Dao dao;
    @Autowired
    private Mapper mapper;

    @Override
    public void createEvent(Accident accident) {
        dao.createEvent(accident);
    }

    @Override
    public List<Accident> getEventByPeriod(String address, Calendar startPeriod, Calendar finisPeriod) {
        return dao.getEventByPeriod(address, startPeriod, finisPeriod);
    }

    @Override
    public List<Accident> getEventByDate(String address, Calendar date) {
        return dao.getEventByDate(address, date);
    }

    @Override
    public WebAccidents getEventByAddress(String address) {
        return mapper.map(dao.getEventByAddress(address));
    }
}

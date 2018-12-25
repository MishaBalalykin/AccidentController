package org.edu.mirea.service.serviceImpl;

import org.edu.mirea.dao.Dao;
import org.edu.mirea.entity.Accident;
import org.edu.mirea.mapper.Mapper;
import org.edu.mirea.service.Service;
import org.edu.mirea.webmodel.AddressAndDateRequest;
import org.edu.mirea.webmodel.AddressAndPeriodRequest;
import org.edu.mirea.webmodel.WebAccident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

/**
 * Created by mr.balalykin on 13.12.2018.
 */

@Component
public class ServiceImpl implements Service {
    private Dao dao;
    private Mapper mapper;

    @Autowired
    public ServiceImpl(Dao dao, Mapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public void createEvent(Accident accident) {
        dao.createEvent(accident);
    }

    @Override
    public List<WebAccident> getEventByAddressAndPeriod(AddressAndPeriodRequest addressAndPeriodRequest) {
        return mapper.map(dao.getEventByAddressAndPeriod(addressAndPeriodRequest));
    }

    @Override
    public List<WebAccident> getGetEventByAddressAndDate(AddressAndDateRequest addressAndDateRequest) {
        return mapper.map(dao.getGetEventByAddressAndDate(addressAndDateRequest));
    }

    @Override
    public List<WebAccident> getEventByAddress(String address) {
        return mapper.map(dao.getEventByAddress(address));
    }
}

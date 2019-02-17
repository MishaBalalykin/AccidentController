package org.edu.mirea.service.serviceImpl;

import org.edu.mirea.dao.Dao;
import org.edu.mirea.mapper.Mapper;
import org.edu.mirea.service.Service;
import org.edu.mirea.webmodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public void createAccident(WebAccident accident) {
        dao.createAccident(mapper.map(accident));
    }

    @Override
    public List<WebAccident> getAccidentByAddressAndPeriod(AddressAndPeriodRequest addressAndPeriodRequest) {
        return mapper.map(dao.getAccidentByAddressAndPeriod(addressAndPeriodRequest));
    }

    @Override
    public List<WebAccident> getAccidentByAddressAndDate(AddressAndDateRequest addressAndDateRequest) {
        return mapper.map(dao.getAccidentByAddressAndDate(addressAndDateRequest));
    }

    @Override
    public List<WebAccident> getAccidentByAddress(String address) {
        return mapper.map(dao.getAccidentByAddress(address));
    }

    @Override
    public List<WebAccident> getAccidentByPeriod(Period period) {
        return mapper.map(dao.getAccidentByPeriod(period));
    }

    @Override
    public List<WebAccident> getAccidentByDate(Date date) {
        return mapper.map(dao.getAccidentByDate(date));
    }
}

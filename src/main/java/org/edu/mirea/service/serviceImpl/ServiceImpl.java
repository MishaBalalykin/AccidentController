package org.edu.mirea.service.serviceImpl;

import org.edu.mirea.dao.Dao;
import org.edu.mirea.entity.Accident;
import org.edu.mirea.service.Service;
import org.edu.mirea.webmodel.AddressAndDateRequest;
import org.edu.mirea.webmodel.AddressAndPeriodRequest;
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

    @Autowired
    public ServiceImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void createEvent(Accident accident) {
        dao.createEvent(accident);
    }

    @Override
    public List<Accident> getEventByAddressAndPeriod(AddressAndPeriodRequest addressAndPeriodRequest) {
        return dao.getEventByAddressAndPeriod(addressAndPeriodRequest);
    }

    @Override
    public List<Accident> getGetEventByAddressAndDate(AddressAndDateRequest addressAndDateRequest) {
        return dao.getGetEventByAddressAndDate(addressAndDateRequest);
    }

    @Override
    public List<Accident> getEventByAddress(String address) {
        return dao.getEventByAddress(address);
    }
}

package org.edu.mirea.service.serviceImpl;

import org.edu.mirea.dao.Dao;
import org.edu.mirea.entity.Accident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.edu.mirea.service.Service;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

/**
 * Created by mr.balalykin on 13.12.2018.
 */

@Component
public class ServiceImpl implements Service {
    @Autowired
    private Dao dao;

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
    public List<Accident> getEventByAddress(String address) {
        return dao.getEventByAddress(address);
    }
}
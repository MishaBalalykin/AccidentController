package service.serviceImpl;

import dao.Dao;
import entity.Accident;
import org.springframework.stereotype.Component;
import service.Service;

import java.util.Calendar;
import java.util.List;

/**
 * Created by mr.balalykin on 13.12.2018.
 */

@Component
public class ServiceImpl implements Service {
    private Dao dao = new Dao();

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

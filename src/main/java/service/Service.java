package service;

import entity.Accident;

import java.util.Calendar;
import java.util.List;

/**
 * Created by mr.balalykin on 13.12.2018.
 */
public interface Service {
    void createEvent(Accident accident);

    List<Accident> getEventByPeriod(String address, Calendar startPeriod, Calendar finisPeriod);

    List<Accident> getEventByDate(String address, Calendar date);
}

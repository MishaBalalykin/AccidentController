package org.edu.mirea.service;

import org.edu.mirea.entity.Accident;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

/**
 * Created by mr.balalykin on 13.12.2018.
 */

@Component
public interface Service {
    void createEvent(Accident accident);

    List<Accident> getEventByPeriod(String address, Calendar startPeriod, Calendar finisPeriod);

    List<Accident> getEventByDate(String address, Calendar date);

    List<Accident> getEventByAddress(String address);
}

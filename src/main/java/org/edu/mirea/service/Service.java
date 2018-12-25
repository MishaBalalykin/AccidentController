package org.edu.mirea.service;

import org.edu.mirea.entity.Accident;
import org.edu.mirea.webmodel.AddressAndDateRequest;
import org.edu.mirea.webmodel.AddressAndPeriodRequest;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

/**
 * Created by mr.balalykin on 13.12.2018.
 */

@Component
public interface Service {
    void createEvent(Accident accident);

    List<Accident> getEventByAddressAndPeriod(AddressAndPeriodRequest addressAndPeriodRequest);

    List<Accident> getGetEventByAddressAndDate(AddressAndDateRequest addressAndDateRequest);

    List<Accident> getEventByAddress(String address);
}

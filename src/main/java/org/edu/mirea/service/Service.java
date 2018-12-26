package org.edu.mirea.service;

import org.edu.mirea.entity.Accident;
import org.edu.mirea.webmodel.AddressAndDateRequest;
import org.edu.mirea.webmodel.AddressAndPeriodRequest;
import org.edu.mirea.webmodel.WebAccident;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

/**
 * Created by mr.balalykin on 13.12.2018.
 */

@Component
public interface Service {
    void createEvent(WebAccident accident);

    List<WebAccident> getEventByAddressAndPeriod(AddressAndPeriodRequest addressAndPeriodRequest);

    List<WebAccident> getGetEventByAddressAndDate(AddressAndDateRequest addressAndDateRequest);

    List<WebAccident> getEventByAddress(String address);
}

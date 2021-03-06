package org.edu.mirea.service;

import org.edu.mirea.webmodel.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by mr.balalykin on 13.12.2018.
 */

@Component
public interface Service {
    void createAccident(WebAccident accident);

    List<WebAccident> getAccidentByAddressAndPeriod(AddressAndPeriodRequest addressAndPeriodRequest);

    List<WebAccident> getAccidentByAddressAndDate(AddressAndDateRequest addressAndDateRequest);

    List<WebAccident> getAccidentByAddress(String address);

    List<WebAccident> getAccidentByPeriod(Period period);

    List<WebAccident> getAccidentByDate(Date date);
}

package org.edu.mirea.controller;

import org.edu.mirea.entity.Accident;
import org.edu.mirea.service.Service;
import org.edu.mirea.webmodel.AddressAndDateRequest;
import org.edu.mirea.webmodel.AddressAndPeriodRequest;
import org.edu.mirea.webmodel.WebAccident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;


/**
 * Created by mr.balalykin on 13.12.2018.
 */

@RestController
@RequestMapping(name = "/accidents")
public class AccidentController{
    Service service;

    @Autowired
    public AccidentController(Service service) {
        this.service = service;
    }

    private static final String CREATE_EVENT = "/create-event";
    private static final String GET_EVENT_BY_ADDRESS_AND_PERIOD = "/get-event-by-address-and-period";
    private static final String GET_EVENT_BY_ADDRESS_AND_DATE = "/get-event-by-address-and-date";
    private static final String GET_EVENT_BY_ADDRESS = "/get-event-by-address/{address}";

    @RequestMapping(value = CREATE_EVENT, method = RequestMethod.POST)
    public void createEvent(Accident accident) {
        service.createEvent(accident);
    }

    @RequestMapping(value = GET_EVENT_BY_ADDRESS_AND_PERIOD, method = RequestMethod.POST)
    @ResponseBody public List<WebAccident> getEventByAddressAndPeriod(@RequestBody AddressAndPeriodRequest addressAndPeriodRequest) {
        List<WebAccident> accidents = service.getEventByAddressAndPeriod(addressAndPeriodRequest);
        return accidents;
    }

    @RequestMapping(value = GET_EVENT_BY_ADDRESS_AND_DATE, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody public List<WebAccident> getGetEventByAddressAndDate(@RequestBody AddressAndDateRequest addressAndDateRequest) {
        return service.getGetEventByAddressAndDate(addressAndDateRequest);
    }

    @RequestMapping(value = GET_EVENT_BY_ADDRESS, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody public List<WebAccident> getGetEventByAddress(@PathVariable String address) {
        return service.getEventByAddress(address);
    }
}

package org.edu.mirea.controller;

import org.edu.mirea.entity.Accident;
import org.edu.mirea.webmodel.output.WebAccidents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.edu.mirea.service.Service;

import java.util.Calendar;
import java.util.List;


/**
 * Created by mr.balalykin on 13.12.2018.
 */

@RestController
@RequestMapping(name = "/accidents")
public class AccidentController{
    @Autowired
    Service service;

    private static final String CREATE_EVENT = "/create-event";
    private static final String GET_EVENT_BY_PERIOD = "/get-event-by-period";
    private static final String GET_EVENT_BY_DATE = "/get-event-by-date";
    private static final String GET_EVENT_BY_ADDRESS = "/get-event-by-address/{address}";

    @RequestMapping(value = CREATE_EVENT, method = RequestMethod.POST)
    public void createEvent(Accident accident) {
        service.createEvent(accident);
    }

    @RequestMapping(value = GET_EVENT_BY_PERIOD, method = RequestMethod.GET)
    public @ResponseBody List<Accident> getEventByPeriod(String address, Calendar startPeriod, Calendar finishPeriod) {
        return service.getEventByPeriod(address, startPeriod, finishPeriod);
    }

    @RequestMapping(value = GET_EVENT_BY_DATE, method = RequestMethod.GET)
    public List<Accident> getGetEventByDate(String address, Calendar date) {
        return service.getEventByDate(address, date);
    }

    @RequestMapping(value = GET_EVENT_BY_ADDRESS, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody public WebAccidents getGetEventByAddress(@PathVariable String address) {
        WebAccidents accidents = service.getEventByAddress(address);
        return accidents;
    }
}

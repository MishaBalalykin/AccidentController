package controller;

import entity.Accident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.Service;

import java.util.Calendar;


/**
 * Created by mr.balalykin on 13.12.2018.
 */

@Controller
@RequestMapping(name = "/accidents")
public class AccidentController {
    @Autowired
    Service service;

    private static final String CREATE_EVENT = "/create-event";
    private static final String GET_EVENT_BY_PERIOD = "/get-event-by-period";
    private static final String GET_EVENT_BY_DATE = "/get-event-by-date";

    @RequestMapping(name = CREATE_EVENT, method = RequestMethod.POST)
    public void createEvent(Accident accident) {
        service.createEvent(accident);
    }

    @RequestMapping(name = GET_EVENT_BY_PERIOD, method = RequestMethod.GET)
    public void getEventByPeriod(String address, Calendar startPeriod, Calendar finishPeriod) {
        service.getEventByPeriod(address, startPeriod, finishPeriod);
    }

    @RequestMapping(name = GET_EVENT_BY_DATE, method = RequestMethod.GET)
    public void getGetEventByDate(String address, Calendar date) {
        service.getEventByDate(address, date);
    }
}

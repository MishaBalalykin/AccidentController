package org.edu.mirea.controller;

import org.edu.mirea.service.Service;
import org.edu.mirea.webmodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;


/**
 * Created by mr.balalykin on 13.12.2018.
 */

@RestController
@RequestMapping(name = "/accidents")
public class AccidentController {
    Service service;

    @Autowired
    public AccidentController(Service service) {
        this.service = service;
    }

    private static final String CREATE_ACCIDENT = "/create-accident";
    private static final String GET_ACCIDENT_BY_ADDRESS_AND_PERIOD = "/get-accident-by-address-and-period";
    private static final String GET_ACCIDENT_BY_ADDRESS_AND_DATE = "/get-accident-by-address-and-date";
    private static final String GET_ACCIDENT_BY_ADDRESS = "/get-accident-by-address/{address}";
    private static final String GET_ACCIDENT_BY_PERIOD = "/get-accident-by-period";
    private static final String GET_ACCIDENT_BY_DATE = "/get-accident-by-date";

    @RequestMapping(value = CREATE_ACCIDENT, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public void createEvent(@RequestBody WebAccident accident) {
        service.createEvent(accident);
    }

    @RequestMapping(value = GET_ACCIDENT_BY_ADDRESS_AND_PERIOD, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<WebAccident> getAccidentByAddressAndPeriod(@RequestBody AddressAndPeriodRequest addressAndPeriodRequest) {
        List<WebAccident> accidents = service.getAccidentByAddressAndPeriod(addressAndPeriodRequest);
        return accidents;
    }

    @RequestMapping(value = GET_ACCIDENT_BY_ADDRESS_AND_DATE, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<WebAccident> getGetAccidentByAddressAndDate(@RequestBody AddressAndDateRequest addressAndDateRequest) {
        return service.getGetAccidentByAddressAndDate(addressAndDateRequest);
    }

    @RequestMapping(value = GET_ACCIDENT_BY_ADDRESS, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<WebAccident> getGetAccidentByAddress(@PathVariable String address) {
        return service.getAccidentByAddress(address);
    }
    
    @RequestMapping(value = GET_ACCIDENT_BY_PERIOD, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<WebAccident> getAccidentByPeriod(@RequestBody Period period){
        return service.getAccidentByPeriod(period);
    }

    @RequestMapping(value = GET_ACCIDENT_BY_DATE, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<WebAccident> getAccidentByDate(@RequestBody Date date){
        return service.getAccidentByDate(date);
    }
}

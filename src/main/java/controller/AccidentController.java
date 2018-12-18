package controller;

import entity.Accident;
import entity.MediaProof;
import entity.TextProof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.Service;

import java.util.Set;

/**
 * Created by mr.balalykin on 13.12.2018.
 */

@Controller
@RequestMapping(name = "/accidents")
public class AccidentController {
    @Autowired
    Service service;

    private static final String CREATE_EVENT = "/create-event";

    @RequestMapping(name = CREATE_EVENT, method = RequestMethod.POST)
    public void createEvent(Accident accident){
        service.createEvent(accident);
    }
}

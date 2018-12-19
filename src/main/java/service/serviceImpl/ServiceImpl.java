package service.serviceImpl;

import dao.Dao;
import entity.Accident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.Service;

/**
 * Created by mr.balalykin on 13.12.2018.
 */

@Component
public class ServiceImpl implements Service {
    @Autowired
    Dao dao;

    public void createEvent(Accident accident) {
        Dao dao = new Dao();
        dao.createEvent(accident);
    }
}

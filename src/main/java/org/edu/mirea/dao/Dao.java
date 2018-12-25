package org.edu.mirea.dao;

import org.edu.mirea.entity.Accident;
import org.edu.mirea.webmodel.AddressAndDateRequest;
import org.edu.mirea.webmodel.AddressAndPeriodRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Calendar;
import java.util.List;

/**
 * Created by mr.balalykin on 14.12.2018.
 */

@Component
public class Dao {
    private EntityManager entityManager;

    @Autowired
    public Dao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createEvent(Accident accident) {
//        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(accident);

        commitAndClose(entityManager);
    }

    @Transactional
    public List<Accident> getEventByAddressAndPeriod(AddressAndPeriodRequest addressAndPeriodRequest) {
        String address = addressAndPeriodRequest.getAddress();
        Calendar startPeriod = addressAndPeriodRequest.getStartPeriod();
        Calendar finishPeriod = addressAndPeriodRequest.getFinishPeriod();

        String hql = new StringBuilder()
                .append("from Accident a where a.accidentAddress = '")
                .append(address)
                .append("' and a.accidentDate between to_date(")
                .append(startPeriod.get(Calendar.YEAR))
                .append(startPeriod.get(Calendar.MONTH) + 1)
                .append(startPeriod.get(Calendar.DAY_OF_MONTH))
                .append(", 'YYYY-MM-DD') and to_date(")
                .append(finishPeriod.get(Calendar.YEAR))
                .append(finishPeriod.get(Calendar.MONTH) + 1)
                .append(finishPeriod.get(Calendar.DAY_OF_MONTH) + 1)
                .append(", 'YYYY-MM-DD')")
                .toString();

        Query query = entityManager.createQuery(hql);
        List<Accident> accidents = query.getResultList();

        return accidents;
    }

    @Transactional
    public List<Accident> getGetEventByAddressAndDate(AddressAndDateRequest addressAndDateRequest) {
        String address = addressAndDateRequest.getAddress();
        Calendar date = addressAndDateRequest.getDate();

        String hql = new StringBuilder()
                .append("from Accident a where a.accidentAddress = '")
                .append(address)
                .append("' and a.accidentDate like to_date(")
                .append(date.get(Calendar.YEAR))
                .append(date.get(Calendar.MONTH) + 1)
                .append(date.get(Calendar.DAY_OF_MONTH))
                .append(", 'YYYY-MM-DD')")
                .toString();

        Query query = entityManager.createQuery(hql);
        List<Accident> accidents = query.getResultList();

        return accidents;
    }

    @Transactional
    public List<Accident> getEventByAddress(String address) {
        String hql = new StringBuilder()
                .append("from Accident a where a.accidentAddress = '")
                .append(address)
                .append("'")
                .toString();

        Query query = entityManager.createQuery(hql);
        List<Accident> accidents = query.getResultList();

        return accidents;
    }

    private void commitAndClose(EntityManager entityManager) {
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

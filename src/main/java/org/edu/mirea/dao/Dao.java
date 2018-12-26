package org.edu.mirea.dao;

import org.edu.mirea.entity.Accident;
import org.edu.mirea.webmodel.AddressAndDateRequest;
import org.edu.mirea.webmodel.AddressAndPeriodRequest;
import org.edu.mirea.webmodel.Date;
import org.edu.mirea.webmodel.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by mr.balalykin on 14.12.2018.
 */

@Component
public class Dao {
    private EntityManager entityManager;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public Dao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void createAccident(Accident accident) {
        entityManager.getTransaction().begin();
        entityManager.persist(accident);
        entityManager.getTransaction().commit();
    }

    public List<Accident> getAccidentByAddressAndPeriod(AddressAndPeriodRequest addressAndPeriodRequest) {
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

    public List<Accident> getAccidentByAddressAndDate(AddressAndDateRequest addressAndDateRequest) {
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

    public List<Accident> getAccidentByAddress(String address) {
        String hql = new StringBuilder()
                .append("from Accident a where a.accidentAddress = '")
                .append(address)
                .append("'")
                .toString();

        Query query = entityManager.createQuery(hql);
        List<Accident> accidents = query.getResultList();

        return accidents;
    }

    public List<Accident> getAccidentByPeriod(Period period) {
        Calendar startPeriod = period.getStartPeriod();
        Calendar finishPeriod = period.getFinishPeriod();

        finishPeriod.add(Calendar.DATE, 1); // need for oracle
        

        //TODO придумать как сделать так чтобы дата всегда была в формате YYYY-MM-DD

        String hql = new StringBuilder()
                .append("from Accident a where a.accidentDate between to_date(")
                .append(startPeriod.get(Calendar.YEAR))
                .append(startPeriod.get(Calendar.MONTH) + 1)
                .append(startPeriod.get(Calendar.DAY_OF_MONTH))
                .append(", 'YYYY-MM-DD') and to_date(")
                .append(finishPeriod.get(Calendar.YEAR))
                .append(finishPeriod.get(Calendar.MONTH) + 1)
                .append(finishPeriod.get(Calendar.DAY_OF_MONTH))
                .append(", 'YYYY-MM-DD')")
                .toString();

        Query query = entityManager.createQuery(hql);
        List<Accident> accidents = query.getResultList();

        return accidents;
    }

    public List<Accident> getAccidentByDate(Date webModelOfDate) {
        Calendar date = webModelOfDate.getDate();
        String hql = new StringBuilder()
                .append("from Accident a where a.accidentDate like to_date(")
                .append(date.get(Calendar.YEAR))
                .append(date.get(Calendar.MONTH) + 1)
                .append(date.get(Calendar.DAY_OF_MONTH))
                .append(", 'YYYY-MM-DD')")
                .toString();

        Query query = entityManager.createQuery(hql);
        List<Accident> accidents = query.getResultList();

        return accidents;
    }
}

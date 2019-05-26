package org.edu.mirea.dao;

import org.edu.mirea.entity.Accident;
import org.edu.mirea.webmodel.AddressAndDateRequest;
import org.edu.mirea.webmodel.AddressAndPeriodRequest;
import org.edu.mirea.webmodel.Date;
import org.edu.mirea.webmodel.Period;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by mr.balalykin on 14.12.2018.
 */

@Component
@EnableTransactionManagement
public class Dao {
    @PersistenceContext
    private EntityManager entityManager;

    public void createAccident(Accident accident) {
        entityManager.persist(accident);
    }

    public List<Accident> getAccidentByAddressAndPeriod(AddressAndPeriodRequest addressAndPeriodRequest) {
        String address = addressAndPeriodRequest.getAddress();
        Calendar startPeriod = addressAndPeriodRequest.getStartPeriod();
        Calendar finishPeriod = addressAndPeriodRequest.getFinishPeriod();

        finishPeriod.add(Calendar.DATE, 1); // need for oracle

        String hql = new StringBuilder()
                .append("from Accident a where a.accidentAddress = '")
                .append(address)
                .append("' and a.accidentDate between to_date(")
                .append(getCorrectDateFormat(startPeriod))
                .append(", 'YYYY-MM-DD') and to_date(")
                .append(getCorrectDateFormat(finishPeriod))
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
                .append(getCorrectDateFormat(date))
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

        String hql = new StringBuilder()
                .append("from Accident a where a.accidentDate between to_date(")
                .append(getCorrectDateFormat(startPeriod))
                .append(", 'YYYY-MM-DD') and to_date(")
                .append(getCorrectDateFormat(finishPeriod))
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
                .append(getCorrectDateFormat(date))
                .append(", 'YYYY-MM-DD')")
                .toString();

        Query query = entityManager.createQuery(hql);
        List<Accident> accidents = query.getResultList();

        return accidents;
    }

    private String getCorrectDateFormat(Calendar date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(date.getTime());
    }
}

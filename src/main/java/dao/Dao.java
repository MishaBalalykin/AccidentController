package dao;

import entity.Accident;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Calendar;
import java.util.List;

/**
 * Created by mr.balalykin on 14.12.2018.
 */
@Component

public class Dao {
    public void createEvent(Accident accident) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(accident);

        commitAndClose(entityManager);
    }


    public List<Accident> getEventByPeriod(String address, Calendar startPeriod, Calendar finishPeriod) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

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
                .append(finishPeriod.get(Calendar.DAY_OF_MONTH))
                .append(", 'YYYY-MM-DD')")
                .toString();

        Query query = entityManager.createQuery(hql);
        List<Accident> accidents = query.getResultList();

        commitAndClose(entityManager);
        return accidents;
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        return entityManagerFactory.createEntityManager();
    }

    private void commitAndClose(EntityManager entityManager) {
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Accident> getEventByDate(String address, Calendar date) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

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

        commitAndClose(entityManager);
        return accidents;
    }
}

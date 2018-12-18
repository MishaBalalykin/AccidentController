package dao;

import entity.Accident;
import entity.MediaProof;
import entity.TextProof;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Set;

/**
 * Created by mr.balalykin on 14.12.2018.
 */
@Component

public class Dao {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    public Dao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
    }
//    @Transactional
    public void createEvent(Accident accident) {
        entityManager.getTransaction().begin();
        entityManager.persist(accident);

        commitAndClose();
    }

    private void commitAndClose(){
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

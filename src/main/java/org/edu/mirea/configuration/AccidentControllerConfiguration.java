package org.edu.mirea.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by mr.balalykin on 24.12.2018.
 */
@Configuration
public class AccidentControllerConfiguration {
    @Bean
    @Scope("prototype")
    public EntityManager getEntityManager(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        return entityManagerFactory.createEntityManager();
    }
}

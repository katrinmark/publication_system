package ru.innopolis.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Ekaterina on 08.12.2016.
 */
public class EntityManagerHolder {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("mysql");

    private static final EntityManager ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();

    public static EntityManager getEntityManager(){
        return ENTITY_MANAGER;
    }

}
package ru.innopolis.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * This class initialises Entity Manager that is used in the application
 * for actions with database
 *
 * @see EntityManager
 */
public class EntityManagerHolder {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("mysql");

    private static final EntityManager ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();

    public static EntityManager getEntityManager(){
        return ENTITY_MANAGER;
    }

}
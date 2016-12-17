package ru.innopolis.dao;

import org.springframework.stereotype.Component;
import ru.innopolis.entity.Publication;
import ru.innopolis.exception.CustomException;
import ru.innopolis.model.PublicationModel;
import ru.innopolis.utils.EntityManagerHolder;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * This class implements functionality for operating with data via JDBC
 *
 * @see ru.innopolis.dao.PublicationDAO
 */
@Component
public class PublicationDAOImpl implements PublicationDAO {

    @Override
    public void addPublication(Publication publication){
        EntityManagerHolder.getEntityManager().getTransaction().begin();
        EntityManagerHolder.getEntityManager().persist(publication);
        EntityManagerHolder.getEntityManager().getTransaction().commit();
    }

    @Override
    public List<Publication> getAllPublications() {
        List<Publication> publications = EntityManagerHolder.getEntityManager().createQuery("Select p from  Publication as p", Publication.class).getResultList();
        return publications;
    }
}

package ru.innopolis.dao;

import org.springframework.stereotype.Component;
import ru.innopolis.entity.Profile;
import ru.innopolis.entity.Publication;
import ru.innopolis.utils.EntityManagerHolder;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * This class implements functionality for operating with Publication data via JPA
 *
 * @see ru.innopolis.dao.PublicationDAO
 */
@Component
public class PublicationDAOImpl implements PublicationDAO {
    private EntityManager entityManager = EntityManagerHolder.getEntityManager();

    @Override
    public void addPublication(Publication publication) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(publication);
        } finally {
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public List<Publication> getAllPublications() {
        List<Publication> publications = entityManager.createQuery("Select p FROM  Publication as p", Publication.class).getResultList();
        return publications;
    }

    @Override
    public List<Publication> getPublicationByUsername(String name) {
        Long profileId = getProfileByUsername(name).getId();
        List<Publication> publications = entityManager.createQuery("SELECT p FROM Publication as p WHERE p.profile.id=" + profileId, Publication.class).getResultList();
        return publications;
    }

    @Override
    public Profile getProfileByUsername(String name) {
        return entityManager.createQuery("FROM Profile as p WHERE p.username=\'" + name + "\'", Profile.class).getSingleResult();
    }

    @Override
    public Publication getPublicationById(Long publicationId) {
        return entityManager.find(Publication.class, publicationId);
    }

    @Override
    public Publication updatePublication(Publication publication) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(publication);
        } finally {
            entityManager.getTransaction().commit();
        }
        return getPublicationById(publication.getId());
    }
}

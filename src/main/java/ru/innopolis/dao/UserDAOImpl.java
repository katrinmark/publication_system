package ru.innopolis.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.innopolis.entity.Profile;
import ru.innopolis.entity.Role;
import ru.innopolis.entity.User;
import ru.innopolis.utils.EntityManagerHolder;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


/**
 * This class implements functionality for operating with User data via JPA
 */
@Component
public class UserDAOImpl implements UserDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class.getName());
    private EntityManager entityManager = EntityManagerHolder.getEntityManager();

    public UserDAOImpl() {
    }

    @Override
    public void registerUser(Profile profile, User user) {
        try {
            entityManager.getTransaction().begin();
            Role role = new Role();
            role.setId(1);
            user.setRole(role);
            user.setEnabled(true);
            profile.setUser(user);
            entityManager.persist(user);
            entityManager.persist(profile);
        } finally {
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public Profile getUserByLogin(String username) {
        Profile profile = EntityManagerHolder.getEntityManager().createQuery("SELECT p FROM Profile as p WHERE p.username=\'" + username + "\'", Profile.class).getSingleResult();
        return profile;
    }

    @Override
    public List<Profile> getAllUsers() {
        Query query = entityManager.createQuery("FROM Profile");
        List<Profile> profiles = query.getResultList();
        return profiles;
    }

    @Override
    public void updateUser(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
        } finally {
            entityManager.getTransaction().commit();
        }
    }
}

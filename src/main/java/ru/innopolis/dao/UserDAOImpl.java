package ru.innopolis.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.innopolis.entity.Profile;
import ru.innopolis.entity.Role;
import ru.innopolis.entity.User;
import ru.innopolis.exception.CustomException;
import ru.innopolis.utils.EntityManagerHolder;

import javax.persistence.Query;


/**
 * Created by Ekaterina on 28.11.2016.
 */
@Component
public class UserDAOImpl implements UserDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class.getName());

    public UserDAOImpl() {
    }

    @Override
    public void registerUser(Profile profile, User user){
        EntityManagerHolder.getEntityManager().getTransaction().begin();
        Role role = new Role();
        role.setId(1);
        user.setRole(role);
        profile.setUser(user);
        EntityManagerHolder.getEntityManager().persist(user);
        EntityManagerHolder.getEntityManager().persist(profile);
        EntityManagerHolder.getEntityManager().getTransaction().commit();
    }

    @Override
    public Profile getUserByLogin(String username){
        Profile profile = EntityManagerHolder.getEntityManager().createQuery("SELECT p FROM Profile as p WHERE p.username=\'" + username + "\'", Profile.class).getSingleResult();
        return profile;
    }
}

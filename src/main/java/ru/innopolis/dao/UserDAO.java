package ru.innopolis.dao;

import ru.innopolis.entity.Profile;
import ru.innopolis.entity.User;

import java.util.List;

/**
 * Created by Ekaterina on 28.11.2016.
 */
public interface UserDAO {
    void registerUser(Profile profile, User user);
    Profile getUserByLogin(String login);
    List<Profile> getAllUsers();
    void updateUser(User user);
    User getUserById(Long id);
}

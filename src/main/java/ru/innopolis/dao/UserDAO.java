package ru.innopolis.dao;

import ru.innopolis.entity.Profile;
import ru.innopolis.entity.User;
import ru.innopolis.exception.CustomException;

/**
 * Created by Ekaterina on 28.11.2016.
 */
public interface UserDAO {
    //    public Profile getUserById(String userId) throws CustomException;
//    public List<Profile> getAllUsers() throws CustomException;
    void registerUser(Profile profile, User user);
    Profile getUserByLogin(String login);
}

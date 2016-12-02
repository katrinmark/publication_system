package ru.innopolis.model.dao;

import ru.innopolis.exception.CustomException;
import ru.innopolis.model.dto.UserDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ekaterina on 28.11.2016.
 */
public interface UserDAO {
    public UserDTO getUserById(String userId) throws CustomException;
    public UserDTO getUserByLogin(String login) throws CustomException;
    public List<UserDTO> getAllUsers() throws CustomException;
    public void registerUser(UserDTO userDTO) throws CustomException;
}

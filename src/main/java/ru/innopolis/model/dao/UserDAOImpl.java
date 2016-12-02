package ru.innopolis.model.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.innopolis.constants.Constants;
import ru.innopolis.controller.UserController;
import ru.innopolis.exception.CustomException;
import ru.innopolis.model.dto.UserDTO;
import ru.innopolis.utils.ConnectionPool;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ekaterina on 28.11.2016.
 */
@Component
public class UserDAOImpl implements UserDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class.getName());

    private static final String SELECT_ALL_USERS_QUERY = "SELECT * FROM " + ConnectionPool.getProperties().getProperty("jdbc.table.users");
    private static final String REGISTER_USER_QUERY = "INSERT INTO user (firstName, secondName, email, password) values (?, ?, ?, ?)";

    public UserDAOImpl() {
    }

    @Override
    public UserDTO getUserById(String userId) throws CustomException {
        UserDTO user = null;
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery("SELECT * FROM " + ConnectionPool.getProperties().getProperty("jdbc.table.users")
                    + " WHERE id=\"" + userId + "\"");
            set.next();
            user = new UserDTO(set.getInt(1), set.getString(2), set.getString(3),
                    set.getString(4), set.getString(5));
        } catch (SQLException e) {
            LOGGER.error("Failed get user by id", e);
            throw new CustomException(Constants.ERROR_DB_USER_MSG);
        } finally {
            ConnectionPool.getInstance().putback(connection);
        }
        return user;
    }

    @Override
    public UserDTO getUserByLogin(String login) throws CustomException {
        UserDTO user = null;
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery("SELECT * FROM " + ConnectionPool.getProperties().getProperty("jdbc.table.users")
                    + " WHERE email=\"" + login + "\"");
            set.next();
            user = new UserDTO(set.getInt(1), set.getString(2), set.getString(3),
                    set.getString(4), set.getString(5));
        } catch (SQLException e) {
            LOGGER.error("Failed get user by login", e);
            throw new CustomException(Constants.ERROR_DB_USER_MSG);
        } finally {
            ConnectionPool.getInstance().putback(connection);
        }
        return user;
    }

    @Override
    public List<UserDTO> getAllUsers() throws CustomException {
        List<UserDTO> allUsers = new ArrayList<UserDTO>();
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery(SELECT_ALL_USERS_QUERY);
            while (set.next()) {
                UserDTO userDTO = new UserDTO();
                userDTO.setId(set.getInt(1));
                userDTO.setFirstName(set.getString(2));
                userDTO.setSecondName(set.getString(3));
                userDTO.setEmail(set.getString(4));
                allUsers.add(userDTO);
            }
        } catch (SQLException e) {
            LOGGER.error("Failed get all users", e);
            throw new CustomException(Constants.ERROR_DB_USER_MSG);
        } finally {
            ConnectionPool.getInstance().putback(connection);
        }
        return allUsers;
    }

    @Override
    public void registerUser(UserDTO userDTO) throws CustomException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(REGISTER_USER_QUERY)) {
            preparedStatement.setString(1, userDTO.getFirstName());
            preparedStatement.setString(2, userDTO.getSecondName());
            preparedStatement.setString(3, userDTO.getEmail());
            preparedStatement.setString(4, userDTO.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Failed register a user", e);
            throw new CustomException(Constants.ERROR_DB_USER_MSG);
        } finally {
            ConnectionPool.getInstance().putback(connection);
        }
    }
}

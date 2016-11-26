package ru.innopolis.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.dao.User;
import ru.innopolis.exception.ValidationException;
import ru.innopolis.pool.ConnectionPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class UserManager {
    private static final UserManager INSTANCE = new UserManager();
    private static final Logger LOGGER = LoggerFactory.getLogger(UserManager.class.getName());
    public static final String INSERT_USER_QUERY = "INSERT INTO " + ConnectionPool.getProperties().getProperty("jdbc.table.users")
            + "(firstName, secondName, email, password) VALUES (?, ?, ?, ?)";
    public static final String SELECT_ALL_USERS_QUERY = "SELECT * FROM "
            + ConnectionPool.getProperties().getProperty("jdbc.table.users");

    private UserManager() {
    }

    public static UserManager getInstance() {
        return INSTANCE;
    }

    public void loginUser(HttpServletRequest request) throws ValidationException, SQLException, IOException, ClassNotFoundException {
        String email = request.getParameter("email");
        String password = Base64.getEncoder().encodeToString(request.getParameter("password").getBytes());
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            throw new ValidationException("Email или пароль не были получены");
        }
        User user = getUser(email);
        if (user == null || !user.getPassword().equals(password)) {
            throw new ValidationException("Неправильные логин или пароль");
        }
        HttpSession session = request.getSession();
        session.setAttribute("id", user.getEmail());
        LOGGER.info("User login: " + email);
    }

    public void logoutUser(HttpServletRequest request) {
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        session.removeAttribute(id);
        LOGGER.info("User logout:" + id);
    }

    public void registerUser(HttpServletRequest req) throws ValidationException, IOException, ClassNotFoundException, SQLException {
        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordConfirm = req.getParameter("passwordConfirm");

        if (firstName == null || secondName == null || email == null || password == null || passwordConfirm == null) {
            throw new ValidationException("Ошибка: некоторые поля не заполнены");
        }

        if ((password != null) && (passwordConfirm != null) && !password.equals(passwordConfirm)) {
            throw new ValidationException("Ошибка: пароли должны совпадать");
        }
        password = Base64.getEncoder().encodeToString(password.getBytes());

        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement statement = (PreparedStatement) connection.createStatement()) {

            statement.setString(1, firstName);
            statement.setString(2, secondName);
            statement.setString(3, email);
            statement.setString(4, password);

            statement.executeUpdate(INSERT_USER_QUERY);
        } finally {
            ConnectionPool.getInstance().putback(connection);
        }
    }

    public User getUser(String email) throws IOException, ClassNotFoundException, SQLException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        User user = null;
        try (Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery("SELECT * FROM " + ConnectionPool.getProperties().getProperty("jdbc.table.users")
                    + " WHERE email=\"" + email + "\"");
            set.next();
            user = new User(set.getString(2), set.getString(3),
                    set.getString(4), set.getString(5));
        } finally {
            ConnectionPool.getInstance().putback(connection);
        }
        return user;
    }

    public List<User> getAllUsers() throws IOException, ClassNotFoundException, SQLException {
        List<User> allUsers = new ArrayList<User>();
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery("SELECT * FROM " + ConnectionPool.getProperties().getProperty("jdbc.table.users"));
            while (set.next()) {
                allUsers.add(new User(set.getString(2), set.getString(3),
                        set.getString(4), set.getString(5)));
            }
        } finally {
            ConnectionPool.getInstance().putback(connection);
        }
        return allUsers;
    }

    public void deleteUser() {

    }

    public void updateUser() {

    }
}

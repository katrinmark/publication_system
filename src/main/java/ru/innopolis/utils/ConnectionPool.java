package ru.innopolis.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.innopolis.constants.Constants;
import ru.innopolis.exception.CustomException;

import javax.annotation.PreDestroy;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * This class is used to manage a limit set of connections.
 * Due to the reason that connect creation is a resource-intensive operation,
 * utils connection can help to reuse the created earlier connections.
 * To use a connection it is necessary to getConnection and finally put it back to the utils.
 */
@Component
public class ConnectionPool {
    public static final Logger LOGGER = LoggerFactory.getLogger(ConnectionPool.class.getName());

    private static ConnectionPool INSTANCE;
    private List<Connection> availableConnections = new ArrayList<Connection>();
    private List<Connection> givenConnections = new ArrayList<Connection>();
    private static int connNumber;
    private static int createdConnNumber = 0;
    private static Properties properties = new Properties();

    private ConnectionPool() throws CustomException {
        FileInputStream in = null;
        try {
            in = new FileInputStream("C:\\Users\\Ekaterina\\IdeaProjects\\PublicationIS\\src\\main\\resources\\db.properties");
            properties.load(in);
            Class.forName(properties.getProperty("jdbc.driver"));
            connNumber = Integer.parseInt(properties.getProperty("jdbc.connections.max.number"));
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.error("Failed creating connection pool", e);
            throw new CustomException(Constants.ERROR_DB_USER_MSG);
        }
    }

    /**
     * Returns available connection from the utils or creates a new one.
     * After using a connection it should be put back to the utils
     * @see ConnectionPool#putback
     * @return null if all connections are busy
     * @throws SQLException in case of invalid connection creation
     */
    public synchronized Connection getConnection() throws CustomException {
        Connection connection = null;
        if (availableConnections.size() > 0) {
            connection = availableConnections.get(availableConnections.size() - 1);
            givenConnections.add(connection);
            availableConnections.remove(connection);
        } else if (createdConnNumber < connNumber) {
            try {
                connection = createNewConnection();
                createdConnNumber++;
            } catch (SQLException e) {
                LOGGER.error("Failed create connection", e);
                throw new CustomException(Constants.ERROR_DB_USER_MSG);
            }
        }
        return connection;
    }

    /**
     * Should be used to return connection to the utils when it does not need
     * @param connection
     * @see ConnectionPool#getConnection()
     */
    public synchronized void putback(Connection connection){
        givenConnections.remove(connection);
        availableConnections.add(connection);
    }

    /**
     * Close all created connections in the utils
     * WARNING: It should be called on application stopping
     */
    @PreDestroy
    public void closeAllConnections(){
        for (Connection connection : availableConnections) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error("Failed close available connection", e);
            }
        }
        for (Connection connection : givenConnections) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error("Failed close using connection", e);
            }
        }
    }

    /**
     * Creates Connection Pool instance
     * WARNING: it should be called  on application start
     * @throws ClassNotFoundException
     */
    public static ConnectionPool getInstance() throws CustomException {
        if (INSTANCE == null) {
            INSTANCE = new ConnectionPool();
        }
        return INSTANCE;
    }

    /**
     *
     * @return
     */
    public static Properties getProperties() {
        return properties;
    }

    private Connection createNewConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(properties.getProperty("jdbc.url"),
                properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));
        return connection;
    }
}
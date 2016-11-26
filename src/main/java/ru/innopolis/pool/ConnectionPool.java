package ru.innopolis.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.constants.Constants;

import java.io.FileInputStream;
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
 * pool connection can help to reuse the created earlier connections.
 * To use a connection it is necessary to getConnection and finally put it back to the pool.
 */
public class ConnectionPool {
    public static final Logger LOGGER = LoggerFactory.getLogger(ConnectionPool.class.getName());

    private static ConnectionPool INSTANCE;
    private List<Connection> availableConnections = new ArrayList<Connection>();
    private List<Connection> givenConnections = new ArrayList<Connection>();
    private static int connNumber;
    private static int createdConnNumber = 0;
    private static Properties properties = new Properties();

    private ConnectionPool() throws ClassNotFoundException, IOException {
        FileInputStream in = new FileInputStream("C:\\Users\\Ekaterina\\IdeaProjects\\PublicationIS\\src\\main\\resources\\db.properties");
        properties.load(in);
        Class.forName(properties.getProperty("jdbc.driver"));
        connNumber = Integer.parseInt(properties.getProperty("jdbc.connections.max.number"));
    }

    /**
     * Returns available connection from the pool or creates a new one.
     * After using a connection it should be put back to the pool
     * @see ConnectionPool#putback
     * @return null if all connections are busy
     * @throws SQLException in case of invalid connection creation
     */
    public synchronized Connection getConnection() throws SQLException {
        Connection connection = null;
        if (availableConnections.size() > 0) {
            connection = availableConnections.get(availableConnections.size() - 1);
            givenConnections.add(connection);
            availableConnections.remove(connection);
        } else if (createdConnNumber < connNumber) {
            connection = createNewConnection();
            createdConnNumber++;
        }
        return connection;
    }

    /**
     * Should be used to return connection to the pool when it does not need
     * @param connection
     * @see ConnectionPool#getConnection()
     */
    public synchronized void putback(Connection connection){
        givenConnections.remove(connection);
        availableConnections.add(connection);
    }

    /**
     * Close all created connections in the pool
     * WARNING: It should be called on application stopping
     */
    public void closeAllConnections(){
        for (Connection connection : availableConnections) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        for (Connection connection : givenConnections) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Creates Connection Pool instance
     * WARNING: it should be called  on application start
     * @throws ClassNotFoundException
     */
    public static ConnectionPool getInstance() throws IOException, ClassNotFoundException {
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
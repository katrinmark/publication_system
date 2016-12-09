package ru.innopolis.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.innopolis.entity.Profile;
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

//    @Override
//    public Profile getUserById(String userId) throws CustomException {
//        Profile user = null;
//        Connection connection = ConnectionPool.getInstance().getConnection();
//        try (Statement statement = connection.createStatement()) {
//            ResultSet set = statement.executeQuery("SELECT * FROM " + ConnectionPool.getProperties().getProperty("jdbc.table.users")
//                    + " WHERE id=\"" + userId + "\"");
//            set.next();
//            user = new Profile(set.getInt(1), set.getString(2), set.getString(3),
//                    set.getString(4), set.getString(5));
//        } catch (SQLException e) {
//            LOGGER.error("Failed get user by id", e);
//            throw new CustomException(Constants.ERROR_DB_USER_MSG);
//        } finally {
//            ConnectionPool.getInstance().putback(connection);
//        }
//        return user;
//    }

//    @Override
//    public Profile getUserByLogin(String login) throws CustomException {
//        Profile user = null;
//        Connection connection = ConnectionPool.getInstance().getConnection();
//        try (Statement statement = connection.createStatement()) {
//            ResultSet set = statement.executeQuery("SELECT * FROM " + ConnectionPool.getProperties().getProperty("jdbc.table.users")
//                    + " WHERE email=\"" + login + "\"");
//            set.next();
//            user = new Profile(set.getInt(1), set.getString(2), set.getString(3),
//                    set.getString(4), set.getString(5));
//        } catch (SQLException e) {
//            LOGGER.error("Failed get user by login", e);
//            throw new CustomException(Constants.ERROR_DB_USER_MSG);
//        } finally {
//            ConnectionPool.getInstance().putback(connection);
//        }
//        return user;
//    }
//
//    @Override
//    public List<Profile> getAllUsers() throws CustomException {
//        List<Profile> allUsers = new ArrayList<Profile>();
//        Connection connection = ConnectionPool.getInstance().getConnection();
//        try (Statement statement = connection.createStatement()) {
//            ResultSet set = statement.executeQuery(SELECT_ALL_USERS_QUERY);
//            while (set.next()) {
//                Profile user = new Profile();
//                user.setId(set.getInt(1));
//                user.setFirstName(set.getString(2));
//                user.setSecondName(set.getString(3));
//                user.setEmail(set.getString(4));
//                allUsers.add(user);
//            }
//        } catch (SQLException e) {
//            LOGGER.error("Failed get all users", e);
//            throw new CustomException(Constants.ERROR_DB_USER_MSG);
//        } finally {
//            ConnectionPool.getInstance().putback(connection);
//        }
//        return allUsers;
//    }
//
    @Override
    public void registerUser(Profile profile){
        EntityManagerHolder.getEntityManager().getTransaction().begin();
        EntityManagerHolder.getEntityManager().persist(profile);
        EntityManagerHolder.getEntityManager().getTransaction().commit();
    }

    @Override
    public Profile getUserByLogin(String username){
        Profile profile = null;
        //EntityManagerHolder.getEntityManager().
        return profile;
    }
}

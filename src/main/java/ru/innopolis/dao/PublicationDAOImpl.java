package ru.innopolis.dao;

import org.springframework.stereotype.Component;
import ru.innopolis.entity.Publication;
import ru.innopolis.exception.CustomException;
import ru.innopolis.model.PublicationModel;
import ru.innopolis.utils.EntityManagerHolder;

/**
 * This class implements functionality for operating with data via JDBC
 *
 * @see ru.innopolis.dao.PublicationDAO
 */
@Component
public class PublicationDAOImpl implements PublicationDAO {

    @Override
    public void addPublication(Publication publication){
        EntityManagerHolder.getEntityManager().getTransaction().begin();
        EntityManagerHolder.getEntityManager().persist(publication);
        EntityManagerHolder.getEntityManager().getTransaction().commit();
    }
//    private static Logger LOGGER = LoggerFactory.getLogger(PublicationDAOImpl.class.getName());
//    private static final String ADD_PUBLICATION_QUERY = "INSERT INTO publication (authorId, title, content) VALUES (?, ?, ?)";
//    private static final String GET_USER_PUBLICATIONS_QUERY = "SELECT * FROM publication WHERE authorId=";
//    private static final String GET_ALL_PUBLICATIONS_QUERY = "SELECT * FROM publication";
//
//    @Override
//    public List<Publication> getPublications(String userId) throws CustomException {
//        List<Publication> publications = new ArrayList<Publication>();
//        Connection connection = ConnectionPool.getInstance().getConnection();
//        try (Statement statement = connection.createStatement()) {
//            ResultSet set = statement.executeQuery(GET_USER_PUBLICATIONS_QUERY + userId);
//            while (set.next()) {
//                publications.add(new Publication(set.getInt(2), set.getString(3), set.getString(4)));
//            }
//        } catch (SQLException e) {
//            LOGGER.error("Failed get publications", e);
//            throw new CustomException(Constants.ERROR_DB_USER_MSG);
//        } finally {
//            ConnectionPool.getInstance().putback(connection);
//        }
//        return publications;
//    }
//
//    @Override
//    public void addPublication(Publication publication) throws CustomException {
//        Connection connection = ConnectionPool.getInstance().getConnection();
//        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_PUBLICATION_QUERY)) {
//            preparedStatement.setInt(1, publication.getAuthorId());
//            preparedStatement.setString(2, publication.getTitle());
//            preparedStatement.setString(3, publication.getContent());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            LOGGER.error("Failed add publication", e);
//            throw new CustomException(Constants.ERROR_DB_USER_MSG);
//        } finally {
//            ConnectionPool.getInstance().putback(connection);
//        }
//    }
//
//    @Override
//    public List<Publication> getAllPublications() throws CustomException {
//        List<Publication> publications = new ArrayList<Publication>();
//        Connection connection = ConnectionPool.getInstance().getConnection();
//        try (Statement statement = connection.createStatement()) {
//            ResultSet set = statement.executeQuery(GET_ALL_PUBLICATIONS_QUERY);
//            while (set.next()) {
//                publications.add(new Publication(set.getInt(2), set.getString(3), set.getString(4)));
//            }
//        } catch (SQLException e) {
//            LOGGER.error("Failed get connection", e);
//            throw new CustomException(Constants.ERROR_DB_USER_MSG);
//        } finally {
//            ConnectionPool.getInstance().putback(connection);
//        }
//
//        return publications;
//    }
}

package ru.innopolis.model.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.innopolis.constants.Constants;
import ru.innopolis.exception.CustomException;
import ru.innopolis.model.dto.PublicationDTO;
import ru.innopolis.utils.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements functionality for operating with data via JDBC
 *
 * @see ru.innopolis.model.dao.PublicationDAO
 */
@Component
public class PublicationDAOImpl implements PublicationDAO {
    private static Logger LOGGER = LoggerFactory.getLogger(PublicationDAOImpl.class.getName());
    private static final String ADD_PUBLICATION_QUERY = "INSERT INTO publication (authorId, title, content) VALUES (?, ?, ?)";
    private static final String GET_USER_PUBLICATIONS_QUERY = "SELECT * FROM publication WHERE authorId=";
    private static final String GET_ALL_PUBLICATIONS_QUERY = "SELECT * FROM publication";

    @Override
    public List<PublicationDTO> getPublications(String userId) throws CustomException {
        List<PublicationDTO> publications = new ArrayList<PublicationDTO>();
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery(GET_USER_PUBLICATIONS_QUERY + userId);
            while (set.next()) {
                publications.add(new PublicationDTO(set.getInt(2), set.getString(3), set.getString(4)));
            }
        } catch (SQLException e) {
            LOGGER.error("Failed get publications", e);
            throw new CustomException(Constants.ERROR_DB_USER_MSG);
        } finally {
            ConnectionPool.getInstance().putback(connection);
        }
        return publications;
    }

    @Override
    public void addPublication(PublicationDTO publicationDTO) throws CustomException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_PUBLICATION_QUERY)) {
            preparedStatement.setInt(1, publicationDTO.getAuthorId());
            preparedStatement.setString(2, publicationDTO.getTitle());
            preparedStatement.setString(3, publicationDTO.getContent());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Failed add publication", e);
            throw new CustomException(Constants.ERROR_DB_USER_MSG);
        } finally {
            ConnectionPool.getInstance().putback(connection);
        }
    }

    @Override
    public List<PublicationDTO> getAllPublications() throws CustomException {
        List<PublicationDTO> publications = new ArrayList<PublicationDTO>();
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery(GET_ALL_PUBLICATIONS_QUERY);
            while (set.next()) {
                publications.add(new PublicationDTO(set.getInt(2), set.getString(3), set.getString(4)));
            }
        } catch (SQLException e) {
            LOGGER.error("Failed get connection", e);
            throw new CustomException(Constants.ERROR_DB_USER_MSG);
        } finally {
            ConnectionPool.getInstance().putback(connection);
        }

        return publications;
    }
}

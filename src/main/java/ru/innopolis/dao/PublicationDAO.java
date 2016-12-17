package ru.innopolis.dao;

import ru.innopolis.entity.Publication;
import java.util.List;

/**
 * This interface describes method for actions with publication table
 */
public interface PublicationDAO {
    void addPublication(Publication publication);

    //    /**
//     *
//     * @param userId
//     * @return
//     * @throws CustomException
//     */
//    public List<Publication> getPublications(String userId) throws CustomException;
//
//    /**
//     *
//     * @param publication
//     * @throws CustomException
//     */
//    public void addPublication(Publication publication) throws CustomException;
    List<Publication> getAllPublications();
}

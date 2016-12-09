package ru.innopolis.dao;

import ru.innopolis.entity.Publication;
import ru.innopolis.model.PublicationModel;

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
//    public List<Publication> getAllPublications() throws CustomException;
}

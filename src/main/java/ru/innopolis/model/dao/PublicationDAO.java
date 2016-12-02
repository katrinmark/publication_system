package ru.innopolis.model.dao;

import ru.innopolis.exception.CustomException;
import ru.innopolis.exception.PublicationException;
import ru.innopolis.model.dto.PublicationDTO;
import java.util.List;

/**
 * This interface describes method for actions with publication table
 */
public interface PublicationDAO {
    /**
     *
     * @param userId
     * @return
     * @throws CustomException
     */
    public List<PublicationDTO> getPublications(String userId) throws CustomException;

    /**
     *
     * @param publicationDTO
     * @throws CustomException
     */
    public void addPublication(PublicationDTO publicationDTO) throws CustomException;
    public List<PublicationDTO> getAllPublications() throws CustomException;
}

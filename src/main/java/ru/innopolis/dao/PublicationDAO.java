package ru.innopolis.dao;

import ru.innopolis.entity.Profile;
import ru.innopolis.entity.Publication;
import java.util.List;

/**
 * This interface describes method for actions with publication table
 */
public interface PublicationDAO {
    void addPublication(Publication publication);
    List<Publication> getAllPublications();
    List<Publication> getPublicationByUsername(String name);
    Profile getProfileByUsername(String name);
    Publication getPublicationById(Long publicationId);
    Publication updatePublication(Publication publication);
}

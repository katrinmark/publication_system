package ru.innopolis.service;

import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.model.PublicationModel;

import java.util.Map;

/**
 * This interface describes methods connected with actions on publications
 */
public interface PublicationService {
    ModelAndView addPublication(PublicationModel publicationModel);
    ModelAndView getAllPublications();
    ModelAndView getPublicationByUsername(String name);
    ModelAndView getPublicationById(Long publicationId);
    ModelAndView updatePublication(PublicationModel publicationModel);
}

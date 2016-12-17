package ru.innopolis.service;

import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.model.PublicationModel;

import java.util.Map;

/**
 * This interface describes methods connected with actions on publications
 */
public interface PublicationService {
    ModelAndView addPublication(PublicationModel publicationModel);

    //    ModelAndView modifyPublication();
//    ModelAndView deletePublication();
//    ModelAndView getPublicationById();
//    ModelAndView getPublicationsByUserId(String userId);
    ModelAndView getAllPublications();
}

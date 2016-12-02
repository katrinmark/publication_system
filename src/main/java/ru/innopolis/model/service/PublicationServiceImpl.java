package ru.innopolis.model.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.controller.UserController;
import ru.innopolis.exception.CustomException;
import ru.innopolis.exception.PublicationException;
import ru.innopolis.model.dao.PublicationDAO;
import ru.innopolis.model.dto.PublicationDTO;

import java.util.Map;

/**
 * This class implements methods connected with actions on publications
 *
 * @see PublicationDAO
 */
@Component
public class PublicationServiceImpl implements PublicationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PublicationServiceImpl.class.getName());

    @Autowired
    private PublicationDAO publicationDAO;

    @Override
    public ModelAndView addPublication(String userId, Map<String, String> publication) {
        ModelAndView modelAndView = new ModelAndView("add_publication");
        try {
            publicationDAO.addPublication(new PublicationDTO(Integer.parseInt(userId), publication.get("title"), publication.get("content")));
        } catch (CustomException e) {
            modelAndView.addObject("error", e.getMessage());
        }
        return modelAndView;
    }

    @Override
    public ModelAndView modifyPublication() {
        return null;
    }

    @Override
    public ModelAndView deletePublication() {
        return null;
    }

    @Override
    public ModelAndView getPublicationById() {
        return null;
    }

    @Override
    public ModelAndView getPublicationsByUserId(String userId) {
        ModelAndView modelAndView = new ModelAndView("user_publications");
        try {
            modelAndView.addObject("publications", publicationDAO.getPublications(userId));
        } catch (CustomException e) {
            modelAndView.addObject("error", e.getMessage());
        }
        return modelAndView;
    }

    @Override
    public ModelAndView getAllPublications() {
        ModelAndView modelAndView = new ModelAndView("publication_board");
        try {
            modelAndView.addObject("publications", publicationDAO.getAllPublications());
        } catch (CustomException e) {
            modelAndView.addObject("error", e.getMessage());
        }
        return modelAndView;
    }
}

package ru.innopolis.model.service;

import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * This interface describes methods connected with actions on publications
 */
public interface PublicationService {
    public ModelAndView addPublication(String userId, Map<String, String> publication);
    public ModelAndView modifyPublication();
    public ModelAndView deletePublication();
    public ModelAndView getPublicationById();
    public ModelAndView getPublicationsByUserId(String userId);
    public ModelAndView getAllPublications();
}

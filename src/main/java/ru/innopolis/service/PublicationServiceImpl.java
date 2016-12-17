package ru.innopolis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.dao.PublicationDAO;
import ru.innopolis.entity.Profile;
import ru.innopolis.entity.Publication;
import ru.innopolis.exception.CustomException;
import ru.innopolis.model.PublicationModel;
import ru.innopolis.utils.BaseMapper;

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
    public ModelAndView addPublication(PublicationModel publicationModel) {
        ModelAndView modelAndView = new ModelAndView("add_publication");
        Publication publication = BaseMapper.MAPPER_FACTORY.getMapperFacade().map(publicationModel, Publication.class);
        publicationDAO.addPublication(publication);
        return modelAndView;
    }

    @Override
    public ModelAndView getAllPublications() {
        ModelAndView modelAndView = new ModelAndView("publication_board");
        modelAndView.addObject("publications", publicationDAO.getAllPublications());
        return modelAndView;
    }
}

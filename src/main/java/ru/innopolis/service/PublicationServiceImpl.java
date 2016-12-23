package ru.innopolis.service;

import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.dao.PublicationDAO;
import ru.innopolis.entity.Profile;
import ru.innopolis.entity.Publication;
import ru.innopolis.model.ProfileModel;
import ru.innopolis.model.PublicationModel;
import ru.innopolis.utils.BaseMapper;

/**
 * This class implements methods connected with actions on publications
 *
 * @see PublicationDAO
 */
@Component
public class PublicationServiceImpl implements PublicationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PublicationServiceImpl.class.getName());
    private MapperFacade mapper = BaseMapper.MAPPER_FACADE;

    @Autowired
    private PublicationDAO publicationDAO;

    @Override
    public ModelAndView addPublication(PublicationModel publicationModel) {
        ModelAndView modelAndView = new ModelAndView("add_publication");
        Publication publication = mapper.map(publicationModel, Publication.class);
        publication.setProfile(publicationDAO.getProfileByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
        publicationDAO.addPublication(publication);
        return modelAndView;
    }

    @Override
    public ModelAndView getAllPublications() {
        ModelAndView modelAndView = new ModelAndView("publication_board");
        modelAndView.addObject("publications", publicationDAO.getAllPublications());
        return modelAndView;
    }

    @Override
    public ModelAndView getPublicationByUsername(String name) {
        ModelAndView modelAndView = new ModelAndView("user_publications");
        modelAndView.addObject("publications", publicationDAO.getPublicationByUsername(name));
        return modelAndView;
    }

    @Override
    public ModelAndView getPublicationById(Long publicationId) {
        ModelAndView modelAndView = new ModelAndView("publication_view");
        Publication publication = publicationDAO.getPublicationById(publicationId);
        PublicationModel publicationModel = mapper.map(publication, PublicationModel.class);
        ProfileModel profileModel = mapper.map(publication.getProfile(), ProfileModel.class);
        publicationModel.setProfileModel(profileModel);
        modelAndView.addObject("publication", publicationModel);
        return modelAndView;
    }

    @Override
    public ModelAndView updatePublication(PublicationModel publicationModel) {
        ModelAndView modelAndView = new ModelAndView("publication_view");
        Publication publication = mapper.map(publicationModel, Publication.class);
        ProfileModel profileModel = publicationModel.getProfileModel();
        Profile profile = mapper.map(profileModel, Profile.class);
        publication.setProfile(profile);
        Publication updatedPublication = publicationDAO.updatePublication(publication);
        PublicationModel publicationModelUpdated = mapper.map(updatedPublication, PublicationModel.class);
        publicationModelUpdated.setProfileModel(profileModel);
        modelAndView.addObject("publication", publicationModelUpdated);
        return modelAndView;
    }
}

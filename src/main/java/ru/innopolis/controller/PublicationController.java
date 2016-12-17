package ru.innopolis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.model.PublicationModel;
import ru.innopolis.service.PublicationService;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * This class is used to handle requests connected with publications
 */
@Controller
public class PublicationController {
    private static final Logger LOGGGER = LoggerFactory.getLogger(PublicationController.class.getName());

    @Autowired
    private PublicationService publicationService;

    @Secured("ROLE_USER")
    @GetMapping("/publication/add")
    public ModelAndView addPublication() {
        return new ModelAndView("add_publication");
    }

    @Secured("ROLE_USER")
    @PostMapping("/publication/add")
    public ModelAndView handleAddPublication(PublicationModel publicationModel) {
        return publicationService.addPublication(publicationModel);
    }

//    @GetMapping("/publication/user_publications")
//    public ModelAndView getUserPublications(HttpSession session) {
//        return publicationService.getPublicationsByUserId(session.getAttribute("userId").toString());
//    }
//
    @GetMapping("/portal/main")
    public ModelAndView geAllPublications() {
        return publicationService.getAllPublications();
    }
}

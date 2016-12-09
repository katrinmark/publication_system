package ru.innopolis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.model.ProfileModel;
import ru.innopolis.model.UserModel;
import ru.innopolis.entity.Profile;
import ru.innopolis.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * This controller is used to handle all requests connected with user management
 */
@Controller
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class.getName());
    @Autowired
    private UserService userService;


    @GetMapping(value = "/register")
    public ModelAndView registerUser() {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("userForm", new Profile());
        return modelAndView;
    }

    @PostMapping(value = "/register")
    public ModelAndView handleRegisterUser(ProfileModel profileModel) {
        return userService.register(profileModel);
    }

    @GetMapping(value = "/login")
    public ModelAndView loginUser() {
        return new ModelAndView("login");
    }

//
//    @GetMapping(value = "/logout")
//    public ModelAndView logoutUser(HttpSession session) {
//        return userService.logoutUser(session);
//    }
//
    @Secured("ROLE_USER")
    @GetMapping(value = "/user/profile")
    public ModelAndView getUserProfile(HttpSession session) {
        //return userService.getUserProfile(session.getAttribute("userId").toString());
        return new ModelAndView("user_profile");
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/admin/profile")
    public ModelAndView getAdminProfile() {
        //return userService.getAdminProfile();
        return new ModelAndView("admin_profile");
    }
}

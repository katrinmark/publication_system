package ru.innopolis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.exception.ValidationException;
import ru.innopolis.model.ProfileModel;
import ru.innopolis.model.UserModel;
import ru.innopolis.entity.Profile;
import ru.innopolis.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @ExceptionHandler(Exception.class)
    @PostMapping(value = "/register")
    public ModelAndView handleRegisterUser(ProfileModel profileModel, UserModel userModel) throws ValidationException {
        return userService.register(profileModel, userModel);
    }

    @GetMapping(value = "/login")
    public ModelAndView loginUser() {
        return new ModelAndView("login");
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping(value = "/profile")
    public ModelAndView getUserProfile(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return getAdminProfile();
        } else {
            return userService.getUserProfile();
        }
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/admin/profile")
    public ModelAndView getAdminProfile() {
        return userService.getAdminProfile();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping(value = "/user/update")
    public ModelAndView updateUser(UserModel userModel) {
        userService.updateUser(userModel);
        return getAdminProfile();
    }

    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}

package ru.innopolis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.exception.CustomException;
import ru.innopolis.model.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Map;

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
        return new ModelAndView("register");
    }

    @PostMapping(value = "/register")
    public ModelAndView handleRegisterUser(@RequestParam Map<String, String> user) {
        return userService.register(user);
    }

    @GetMapping(value = "/login")
    public ModelAndView loginUser() {
        return new ModelAndView("login");
    }

    @PostMapping(value = "/login")
    public ModelAndView handleLoginUser(HttpSession session,
                                        @RequestParam(value = "login") String login,
                                        @RequestParam(value = "password") String password) {
        return userService.loginUser(session, login, password);
    }

    @GetMapping(value = "/logout")
    public ModelAndView logoutUser(HttpSession session) {
        return userService.logoutUser(session);
    }

    @GetMapping(value = "/user_profile")
    public ModelAndView getUserProfile(HttpSession session) {
        return userService.getUserProfile(session.getAttribute("userId").toString());
    }

    @GetMapping(value = "/admin_profile")
    public ModelAndView getAdminProfile() {
        return userService.getAdminProfile();
    }
}

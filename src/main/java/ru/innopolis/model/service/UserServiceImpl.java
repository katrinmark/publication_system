package ru.innopolis.model.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.exception.CustomException;
import ru.innopolis.exception.ValidationException;
import ru.innopolis.model.dao.UserDAO;
import ru.innopolis.model.dto.UserDTO;
import ru.innopolis.utils.Md5Util;
import ru.innopolis.utils.ValidatorUtil;

import javax.servlet.http.HttpSession;
import java.util.*;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class.getName());

    public UserServiceImpl() {
    }

    @Override
    public ModelAndView loginUser(HttpSession session, String login, String password) {
        ModelAndView modelAndView = null;
        try {
            password = Md5Util.md5EncodePassword(password);
            UserDTO user = userDAO.getUserByLogin(login);
            if (user.getPassword().equals(password)) {
                session.setAttribute("userId", user.getId());

                if ("admin".equals(user.getFirstName())) {
                    modelAndView = new ModelAndView("redirect:/admin_profile");
                    modelAndView.getModelMap().addAttribute("users", userDAO.getAllUsers());
                } else {
                    modelAndView = new ModelAndView("redirect:/user_profile");
                    modelAndView.getModelMap().addAttribute("firstName", user.getFirstName());
                    modelAndView.getModelMap().addAttribute("secondName", user.getSecondName());
                    modelAndView.getModelMap().addAttribute("email", user.getEmail());
                }
            } else {
                modelAndView = new ModelAndView("login");
                modelAndView.addObject("error", "Неправильные логин или пароль");
            }
        } catch (CustomException e) {
            modelAndView.addObject("error", e.getMessage());
        }
        return modelAndView;
    }

    @Override
    public ModelAndView logoutUser(HttpSession session) {
        session.invalidate();
        return new ModelAndView("redirect:/login");
    }

    @Override
    public ModelAndView getAdminProfile() {
        ModelAndView modelAndView = new ModelAndView("admin_profile");
        try {
            modelAndView.addObject("users", userDAO.getAllUsers());
        } catch (CustomException e) {
            modelAndView.addObject("error", e.getMessage());
        }
        return modelAndView;
    }

    @Override
    public ModelAndView getUserProfile(String userId) {
        ModelAndView modelAndView = new ModelAndView("user_profile");
        try {
            modelAndView.addObject("user", userDAO.getUserById(userId));
        } catch (CustomException e) {
            modelAndView.addObject("error", e);
        }
        return modelAndView;
    }

    @Override
    public ModelAndView register(Map<String, String> user) {
        ModelAndView modelAndView = new ModelAndView("redirect:/login");
        String password = user.get("password");
        String confirmPassword = user.get("passwordConfirm");

        try {
            ValidatorUtil.validatePassword(password, confirmPassword);
            UserDTO userDTO = new UserDTO(0, user.get("firstName"), user.get("secondName"), user.get("email"), Md5Util.md5EncodePassword(password));
            userDAO.registerUser(userDTO);
        } catch (ValidationException e) {
            LOGGER.error("Failed validate user data", e);
            modelAndView.addObject("error", e.getMessage());
        } catch (CustomException e) {
            modelAndView.addObject("error", e.getMessage());
        }
        return modelAndView;
    }
}

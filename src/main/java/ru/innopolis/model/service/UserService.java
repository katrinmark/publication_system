package ru.innopolis.model.service;

import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.exception.CustomException;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * This interface describes methods connected with actions on users
 */
public interface UserService {
    public ModelAndView loginUser(HttpSession session, String login, String password);
    public ModelAndView logoutUser(HttpSession session);
    public ModelAndView getAdminProfile();
    public ModelAndView getUserProfile(String userId);
    public ModelAndView register(Map<String, String> user);
}

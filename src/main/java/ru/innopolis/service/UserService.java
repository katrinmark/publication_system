package ru.innopolis.service;

import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.model.ProfileModel;
import ru.innopolis.model.UserModel;

import javax.servlet.http.HttpSession;

/**
 * This interface describes methods connected with actions on users
 */
public interface UserService {
    ModelAndView register(ProfileModel profileModel, UserModel userModel);
    ModelAndView getUserProfile();

    //ModelAndView findByUsername(String username);
}
    /**

    ModelAndView logoutUser(HttpSession session);
    ModelAndView getAdminProfile();

    */

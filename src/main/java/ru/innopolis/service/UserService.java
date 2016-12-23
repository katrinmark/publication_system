package ru.innopolis.service;

import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.exception.ValidationException;
import ru.innopolis.model.ProfileModel;
import ru.innopolis.model.UserModel;

import javax.servlet.http.HttpSession;

/**
 * This interface describes methods connected with actions on users
 */
public interface UserService {
    /**
     * This method prepares data to register a new user
     * @param profileModel
     * @param userModel
     * @return information necessary for presentation
     * @throws ValidationException
     */
    ModelAndView register(ProfileModel profileModel, UserModel userModel) throws ValidationException;

    /**
     * This method prepares data to get a new user
     * @return information necessary for presentation
     */
    ModelAndView getUserProfile();

    /**
     * This method prepares data to register data for admin profile
     * @return information necessary for presentation
     */
    ModelAndView getAdminProfile();

    /**
     * This method is used to update a user by the system administrator
     * @param userModel
     */
    void updateUser(UserModel userModel);
}

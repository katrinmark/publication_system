package ru.innopolis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.entity.User;
import ru.innopolis.exception.CustomException;
import ru.innopolis.exception.ValidationException;
import ru.innopolis.model.ProfileModel;
import ru.innopolis.dao.UserDAO;
import ru.innopolis.entity.Profile;
import ru.innopolis.model.UserModel;
import ru.innopolis.utils.BaseMapper;
import ru.innopolis.utils.ValidatorUtil;

import javax.servlet.http.HttpSession;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class.getName());

    public UserServiceImpl() {
    }

    @Override
    public ModelAndView register(ProfileModel profileModel, UserModel userModel) {
        ModelAndView modelAndView = new ModelAndView("redirect:/login");
        Profile profile = BaseMapper.MAPPER_FACTORY.getMapperFacade().map(profileModel, Profile.class);
        User user = BaseMapper.MAPPER_FACTORY.getMapperFacade().map(userModel, User.class);
        userDAO.registerUser(profile, user);
        return modelAndView;
    }

    @Override
    public ModelAndView getUserProfile() {
        ModelAndView modelAndView = new ModelAndView("user_profile");
        Profile profile = userDAO.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        ProfileModel profileModel = BaseMapper.MAPPER_FACTORY.getMapperFacade().map(profile, ProfileModel.class);
        modelAndView.addObject("user", profileModel);
        return modelAndView;
    }
}

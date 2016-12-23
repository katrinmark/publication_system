package ru.innopolis.service;

import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.entity.User;
import ru.innopolis.exception.ValidationException;
import ru.innopolis.model.ProfileModel;
import ru.innopolis.dao.UserDAO;
import ru.innopolis.entity.Profile;
import ru.innopolis.model.UserModel;
import ru.innopolis.utils.BaseMapper;
import ru.innopolis.utils.ValidatorUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements methods connected with actions on users
 */

@Component
public class UserServiceImpl implements UserService {
    private MapperFacade mapper = BaseMapper.MAPPER_FACADE;

    @Autowired
    private UserDAO userDAO;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class.getName());
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl() {
    }

    @Override
    public ModelAndView register(ProfileModel profileModel, UserModel userModel) throws ValidationException {
        ValidatorUtil.validatePassword(userModel.getPassword(), userModel.getConfirmPassword());
        ModelAndView modelAndView = new ModelAndView("redirect:/login");
        Profile profile = mapper.map(profileModel, Profile.class);
        User user = mapper.map(userModel, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.registerUser(profile, user);
        return modelAndView;
    }

    @Override
    public ModelAndView getUserProfile() {
        ModelAndView modelAndView = new ModelAndView("user_profile");
        Profile profile = userDAO.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        ProfileModel profileModel = mapper.map(profile, ProfileModel.class);
        modelAndView.addObject("user", profileModel);
        return modelAndView;
    }

    @Override
    public ModelAndView getAdminProfile() {
        ModelAndView modelAndView = new ModelAndView("admin_profile");
        List<Profile> profiles = userDAO.getAllUsers();
        List<ProfileModel> profileModels = new ArrayList<>();
        for (Profile profile : profiles) {
            profileModels.add(mapper.map(profile, ProfileModel.class));
        }
        modelAndView.addObject("users", profileModels);
        return modelAndView;
    }

    @Override
    public void updateUser(UserModel userModel) {
        User user = userDAO.getUserById(userModel.getId());
        user.setEnabled(userModel.isEnabled());
        userDAO.updateUser(user);
    }
}

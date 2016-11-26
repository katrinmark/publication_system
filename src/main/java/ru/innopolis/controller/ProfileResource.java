package ru.innopolis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.dao.User;
import ru.innopolis.manager.UserManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * This resource is use to handle client requests connected with user profile
 *
 * @see HttpServlet
 */
public class ProfileResource extends HttpServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(ProfileResource.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getServletContext().getRequestDispatcher("/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserManager.getInstance().logoutUser(req);
    }
}
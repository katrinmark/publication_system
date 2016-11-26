package ru.innopolis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.dao.User;
import ru.innopolis.exception.ValidationException;
import ru.innopolis.manager.UserManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * This resource is used to handle client requests connected with user login.
 * For successful login the user is forwarded to corresponding profile page.
 *
 * @see HttpServlet
 */
public class LoginResource extends HttpServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoginResource.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserManager.getInstance().loginUser(request);
            String userId = (String) request.getSession().getAttribute("id");
            User user = UserManager.getInstance().getUser(userId);
            if (user.getFirstName().equals("admin")) {
                try {
                    request.setAttribute("users", UserManager.getInstance().getAllUsers());
                    request.getServletContext().getRequestDispatcher("/manage_users.jsp").forward(request, response);
                } catch (ClassNotFoundException e) {
                    LOGGER.error("Failed getting user list", e);
                } catch (SQLException e) {
                    LOGGER.error("Failed getting user list", e);
                }
                request.getServletContext().getRequestDispatcher("/manage_users.jsp").forward(request, response);
            } else {
                request.setAttribute("userFirstName", user.getFirstName());
                request.setAttribute("userSecondName", user.getSecondName());
                request.setAttribute("userEmail", user.getEmail());
                request.getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);
            }

        } catch (ValidationException e) {
            LOGGER.error("Login failed", e);
            response.getOutputStream().write(e.getMessage().getBytes());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }
}

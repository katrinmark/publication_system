package ru.innopolis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.exception.ValidationException;
import ru.innopolis.manager.UserManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * This resource is use to handle client requests connected with user registration
 * @see HttpServlet
 */
public class RegistrationResource extends HttpServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(RegistrationResource.class.getName());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserManager.getInstance().registerUser(req);
            String applicationUrl = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort();
            resp.getOutputStream().write(("<html>Успешная регистрация. Можете войти в систему <p><a href=\"" +  applicationUrl + "/login\">Войти в систему</a></p></html>").getBytes());
        } catch (ValidationException e) {
            resp.getOutputStream().write(e.getMessage().getBytes());
        } catch (SQLException e) {
            System.out.println("cannot connect to db");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

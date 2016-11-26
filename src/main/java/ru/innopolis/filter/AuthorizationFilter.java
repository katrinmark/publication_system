package ru.innopolis.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * This filter is used to forward a user to login page if he/she tries to access some pages missing login
 * @see Filter
 */
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.getServletContext().getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

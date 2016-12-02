package ru.innopolis.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This filter is used to forward a user to login page if he/she tries to access some pages missing login
 *
 * @see Filter
 */
@Component(value = "basicFilter")
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (((HttpServletRequest)servletRequest).getSession().getAttribute("userId") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse)servletResponse).sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {

    }
}

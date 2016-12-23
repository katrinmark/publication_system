package ru.innopolis.exception.resolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;

/**
 * This class is used to handle information about validation exception
 * and transfer it to view
 */
public class ValidatorExceptionResolver extends SimpleMappingExceptionResolver {
    private static Logger LOGGER = LoggerFactory.getLogger(ValidatorExceptionResolver.class);

    @Override
    protected ModelAndView getModelAndView(String viewName, Exception ex, HttpServletRequest request) {
        return getExceptionModelAndView(viewName, ex, request);
    }

    private ModelAndView getExceptionModelAndView(String viewName, Exception ex, HttpServletRequest request) {
        ModelAndView modelAndView = super.getModelAndView(viewName, ex);
        modelAndView.addObject("error", ex.getMessage());
        if (request != null) {
            modelAndView.addObject("backLink", request.getRequestURI());
        }
        LOGGER.error("Failed action:", ex);
        return modelAndView;
    }
}

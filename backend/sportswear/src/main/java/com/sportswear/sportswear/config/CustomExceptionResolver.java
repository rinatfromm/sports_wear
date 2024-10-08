package com.sportswear.sportswear.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Component
public class CustomExceptionResolver extends AbstractHandlerExceptionResolver {
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request,
                                              HttpServletResponse response,
                                              Object handler,
                                              Exception ex) {
        final ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        modelAndView.addObject("message", "Not found exception");
        modelAndView.addObject("error", ex.getMessage());
        modelAndView.addObject("loc error", ex.getLocalizedMessage());

        if (ex instanceof ChangeSetPersister.NotFoundException) {
            modelAndView.setStatus(HttpStatus.NOT_FOUND);
            return modelAndView;
        }
        modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return modelAndView;
    }
}

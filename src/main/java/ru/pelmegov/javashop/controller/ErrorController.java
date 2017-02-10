package ru.pelmegov.javashop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorController {

    private static Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler(Throwable.class)
    public ModelAndView exceptionNotFound(final Throwable throwable) {
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }
}

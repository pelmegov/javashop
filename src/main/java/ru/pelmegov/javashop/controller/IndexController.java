package ru.pelmegov.javashop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView indexPage() {
        return new ModelAndView("index");
    }
}

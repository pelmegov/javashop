package ru.pelmegov.javashop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.pelmegov.javashop.api.service.GoodService;

@Controller
public class GoodController {

    private String detailView = "/good/detail";

    @Autowired
    private GoodService goodService;

    @RequestMapping(value = {"/good/detail/{id}"}, method = RequestMethod.GET)
    public ModelAndView detailPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView(detailView);
        modelAndView.addObject("good", goodService.getGoodById(id));

        return modelAndView;
    }
}

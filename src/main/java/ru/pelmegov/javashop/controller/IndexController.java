package ru.pelmegov.javashop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.pelmegov.javashop.api.service.GoodService;
import ru.pelmegov.javashop.model.Good;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private GoodService goodService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView indexPage() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("newGoods", goodService.getLastAddedGoods(4));

        List<Good> catalogProducts = new ArrayList<Good>(goodService.allGoods()).subList(0, 9);
        modelAndView.addObject("firstRowCatalogGoods", catalogProducts.subList(0, 4));
        modelAndView.addObject("secondRowCatalogGoods", catalogProducts.subList(5, 9));
        return modelAndView;
    }
}

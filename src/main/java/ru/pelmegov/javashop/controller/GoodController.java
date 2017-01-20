package ru.pelmegov.javashop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.pelmegov.javashop.api.service.GoodService;
import ru.pelmegov.javashop.model.Good;

import java.util.HashSet;
import java.util.Set;

@Controller
public class GoodController {

    private String detailView = "/good/detail";
    private String categoryView = "/good/category";

    @Autowired
    private GoodService goodService;

    @RequestMapping(value = {"/good/detail/{id}"}, method = RequestMethod.GET)
    public ModelAndView detailPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView(detailView);
        modelAndView.addObject("good", goodService.getGoodById(id));

        return modelAndView;
    }

    @RequestMapping(value = {"/category/{id}"}, method = RequestMethod.GET)
    public ModelAndView category(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView(categoryView);
        modelAndView.addObject("category", id);

        Set<Good> goods = new HashSet<Good>();
        for (Good good: goodService.allGoods()) {
            if(good.getCategory().getId().equals(id)) {
                goods.add(good);
            }
        }
        modelAndView.addObject("goods", goods);

        return modelAndView;
    }
}

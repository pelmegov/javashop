package ru.pelmegov.javashop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.pelmegov.javashop.api.service.GoodService;
import ru.pelmegov.javashop.model.Good;

@Controller
public class GoodController {

    private String detailView = "/good/detail";
    private String categoryView = "/good/category";

    @Autowired
    private GoodService goodService;

    @RequestMapping(value = {"/good/detail/{id}"}, method = RequestMethod.GET)
    public ModelAndView detailPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView(detailView);
        modelAndView.addObject("good", goodService.getGoodById(id));

        return modelAndView;
    }

    @RequestMapping(value = {"/category/{id}"}, method = RequestMethod.GET)
    public ModelAndView category(@PathVariable(value = "id") Integer categoryId) {
        // Сколько товаров выводить в каталоге
        Integer goodsCount = 12;

        ModelAndView modelAndView = new ModelAndView(categoryView);
        modelAndView.addObject("category", categoryId);
        modelAndView.addObject("catalogGoods", goodService.getGoodsByCategory(goodsCount, categoryId));

        return modelAndView;
    }
}

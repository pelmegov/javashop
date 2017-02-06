package ru.pelmegov.javashop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.pelmegov.javashop.service.GoodService;

@Controller
public class GoodController {

    private String detailView = "/good/detail";
    private String categoryView = "/good/category";

    private final GoodService goodService;

    @Autowired
    public GoodController(GoodService goodService) {
        this.goodService = goodService;
    }

    @RequestMapping(value = {"/good/detail/{id}"}, method = RequestMethod.GET)
    public ModelAndView detailPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView(detailView);
        modelAndView.addObject("good", goodService.getGoodById(id, true));

        return modelAndView;
    }

    @RequestMapping(value = {"/category/{id}"}, method = RequestMethod.GET)
    public ModelAndView category(@PathVariable(value = "id") Integer categoryId) {
        // Сколько товаров выводить в каталоге
        Integer goodsCount = 12;

        ModelAndView modelAndView = new ModelAndView(categoryView);
        modelAndView.addObject("category", categoryId);
        modelAndView.addObject("catalogGoods", goodService.getGoodsByCategory(goodsCount, categoryId, true));

        return modelAndView;
    }
}

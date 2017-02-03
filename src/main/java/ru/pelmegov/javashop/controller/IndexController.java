package ru.pelmegov.javashop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.pelmegov.javashop.api.service.GoodService;
import ru.pelmegov.javashop.api.service.NewsService;

@Controller
public class IndexController {

    private String indexView = "/index";

    private final GoodService goodService;

    @Autowired
    public IndexController(GoodService goodService) {
        this.goodService = goodService;
    }

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView indexPage() {
        ModelAndView modelAndView = new ModelAndView(indexView);
        modelAndView.addObject("newGoods", goodService.getLastAddedGoods(4, true));
        modelAndView.addObject("catalogGoods", goodService.getGoods(8, true));
        modelAndView.addObject("listNews", newsService.getLastAddedNews(3));
        return modelAndView;
    }

}

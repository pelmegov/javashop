package ru.pelmegov.javashop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.pelmegov.javashop.api.service.NewsService;

@Controller
public class NewsController {

    private String newsPage = "/news/news";

//    private final NewsService newsService;
//
//    @Autowired
//    public NewsController(NewsService newsService){
//        this.newsService = newsService;
//    }
//
    @Autowired
    public NewsService newsService;

    @RequestMapping(value = {"/news"}, method = RequestMethod.GET)
    public ModelAndView newsPage(){
        ModelAndView modelAndView = new ModelAndView(newsPage);
        modelAndView.addObject("news", newsService.getNews(12));
        return  modelAndView;
    }
}

package ru.pelmegov.javashop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.pelmegov.javashop.model.news.News;
import ru.pelmegov.javashop.service.NewsService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller(value = "adminNewsController")
@RequestMapping(value = "/admin/news")
public class NewsController {

    private String addNewsView = "/admin/news/addNews";
    private String indexNewsView = "/admin/news/index";
    private String updateNewsView = "/admin/news/updateNews";

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(indexNewsView);
        List<News> news = new ArrayList<>(newsService.getNews(100));
        news.sort(Comparator.comparing(News::getId));
        modelAndView.addObject("news", news);
        return modelAndView;
    }

    @RequestMapping(value = "/addNews", method = RequestMethod.GET)
    public ModelAndView addNews(News news) {
        ModelAndView modelAndView = new ModelAndView(addNewsView);
        modelAndView.addObject("news", news);
        return modelAndView;
    }

    @RequestMapping(value = "/addNews", method = RequestMethod.POST)
    public ModelAndView addNews(@ModelAttribute News news, ModelAndView modelAndView, RedirectAttributes redirectAttributes) {
        newsService.addNews(news);
        redirectAttributes.addFlashAttribute("success", "News has added: " + news);
        return new ModelAndView("redirect: " + indexNewsView);
    }

    @RequestMapping(value = {"/updateNews/{id}", "/updateNews"}, method = RequestMethod.GET)
    public ModelAndView updateNews(News news, RedirectAttributes redirectAttrs) {
        ModelAndView modelAndView = new ModelAndView(updateNewsView);
        news = newsService.getNewsById(news.getId());
        modelAndView.addObject("news", news);
        return modelAndView;
    }

    @RequestMapping(value = {"/updateNews"}, method = RequestMethod.POST)
    public ModelAndView updateNews(@Valid @ModelAttribute News news,
                                   final BindingResult result,
                                   final ModelAndView modelAndView,
                                   RedirectAttributes redirectAttrs) {
        newsService.updateNews(news);
        redirectAttrs.addFlashAttribute("success", "News has updated: " + news);
        return new ModelAndView("redirect:" + indexNewsView);
    }

    @RequestMapping(value = {"/deleteNews/{id}"}, method = RequestMethod.GET)
    public String deleteNews(@PathVariable("id") Integer id, RedirectAttributes redirectAttrs) {
        News news = newsService.getNewsById(id);
        newsService.deleteNews(id);
        redirectAttrs.addFlashAttribute("success", "News has deleted: " + news);
        return "redirect:" + indexNewsView;
    }
}

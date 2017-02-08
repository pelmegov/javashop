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
import ru.pelmegov.javashop.model.good.Good;
import ru.pelmegov.javashop.service.CategoryService;
import ru.pelmegov.javashop.service.GoodService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller(value = "adminGoodController")
@RequestMapping("/admin/good")
public class GoodController {

    private String addGoodView = "/admin/good/addGood";
    private String indexGoodView = "/admin/good/index";
    private String updateGoodView = "/admin/good/updateGood";

    private final GoodService goodService;
    private final CategoryService categoryService;

    @Autowired
    public GoodController(GoodService goodService, CategoryService categoryService) {
        this.goodService = goodService;
        this.categoryService = categoryService;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(indexGoodView);
        List<Good> goods = new ArrayList<>(goodService.getAllGoods());
        goods.sort(Comparator.comparing(Good::getId));
        modelAndView.addObject("good", goods);
        return modelAndView;
    }

    @RequestMapping(value = "/addGood", method = RequestMethod.GET)
    public ModelAndView addGood(Good good) {
        ModelAndView modelAndView = new ModelAndView(addGoodView);
        return getGoodModelAndView(modelAndView, good);
    }

    @RequestMapping(value = "/addGood", method = RequestMethod.POST)
    public ModelAndView addGood(@ModelAttribute Good good, BindingResult result, ModelAndView modelAndView, RedirectAttributes redirectAttributes) {
        goodService.addGood(good);
        redirectAttributes.addFlashAttribute("success", "Good has added: " + good);
        return new ModelAndView("redirect: " + indexGoodView);
    }

    @RequestMapping(value = {"/updateGood/{id}", "/updateGood"}, method = RequestMethod.GET)
    public ModelAndView updateGood(Good good, RedirectAttributes redirectAttrs) {
        ModelAndView modelAndView = new ModelAndView(updateGoodView);
        good = goodService.getGoodById(good.getId());
        return getGoodModelAndView(modelAndView, good);
    }

    @RequestMapping(value = {"/updateGood"}, method = RequestMethod.POST)
    public ModelAndView updateGood(@Valid @ModelAttribute Good good,
                                   final BindingResult result,
                                   final ModelAndView modelAndView,
                                   RedirectAttributes redirectAttrs) {
        goodService.updateGood(good);
        redirectAttrs.addFlashAttribute("success", "Good has updated: " + good);
        return new ModelAndView("redirect:" + indexGoodView);
    }

    @RequestMapping(value = {"/deleteGood/{id}"}, method = RequestMethod.GET)
    public String deleteGood(@PathVariable("id") Integer id, RedirectAttributes redirectAttrs) {
        Good good = goodService.getGoodById(id);
        goodService.deleteGood(id);
        redirectAttrs.addFlashAttribute("success", "Good has deleted: " + good);
        return "redirect:" + indexGoodView;
    }

    private ModelAndView getGoodModelAndView(ModelAndView modelAndView, Good good) {
        modelAndView.addObject("currentCategory", good.getCategory());
        modelAndView.addObject("allCategory", categoryService.getAllCategory());
        modelAndView.addObject("good", good);
        return modelAndView;
    }
}

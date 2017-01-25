package ru.pelmegov.javashop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.pelmegov.javashop.api.service.GoodService;
import ru.pelmegov.javashop.api.service.UserService;
import ru.pelmegov.javashop.model.Good;
import ru.pelmegov.javashop.model.User;

import java.util.HashSet;
import java.util.Set;

@Controller
public class CartController {

    private String cartView = "/cart/index";

    @Autowired
    private GoodService goodService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/cart"}, method = RequestMethod.GET)
    public ModelAndView cart() {
        ModelAndView modelAndView = new ModelAndView(cartView);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User user = userService.getUserByLogin(userName);
        modelAndView.addObject("goods", user.getCartGoods());

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = {"/cart/buy"})
    public String buy(@RequestBody String id) {
        Good good = goodService.getGoodById(Integer.valueOf(id));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User user = userService.getUserByLogin(userName);
        Set<Good> goodSet = user.getCartGoods();
        goodSet.add(good);
        user.setCartGoods(goodSet);
        userService.updateUser(user);
        return good.getTitle() + " been successfully added in your cart!";
    }

}

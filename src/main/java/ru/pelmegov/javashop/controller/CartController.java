package ru.pelmegov.javashop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.pelmegov.javashop.api.service.GoodService;
import ru.pelmegov.javashop.api.service.UserService;
import ru.pelmegov.javashop.model.Good;
import ru.pelmegov.javashop.model.User;

@Controller
public class CartController {

    private String cartView = "/cart/index";

    private final GoodService goodService;

    private final UserService userService;

    @Autowired
    public CartController(GoodService goodService, UserService userService) {
        this.goodService = goodService;
        this.userService = userService;
    }

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

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User user = userService.getUserByLogin(userName);
        Good good = goodService.getGoodById(Integer.valueOf(id));

        user.addCartGood(good);
        userService.updateUser(user);

        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString("<b>" + good.getTitle() + "</b> been successfully added in your cart!");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

}

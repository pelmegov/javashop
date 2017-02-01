package ru.pelmegov.javashop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.pelmegov.javashop.api.service.CartService;
import ru.pelmegov.javashop.api.service.GoodService;
import ru.pelmegov.javashop.api.service.UserService;
import ru.pelmegov.javashop.model.cart.Cart;
import ru.pelmegov.javashop.model.cart.Item;
import ru.pelmegov.javashop.model.good.Good;
import ru.pelmegov.javashop.model.user.User;

import java.util.Set;

@Controller
public class CartController {

    private String cartView = "/cart/index";

    private final GoodService goodService;

    private final UserService userService;

    private final CartService cartService;

    @Autowired
    public CartController(GoodService goodService, UserService userService, CartService cartService) {
        this.goodService = goodService;
        this.userService = userService;
        this.cartService = cartService;
    }

    @RequestMapping(value = {"/cart"}, method = RequestMethod.GET)
    public ModelAndView cart() {
        ModelAndView modelAndView = new ModelAndView(cartView);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User user = userService.getUserByLogin(userName);
        modelAndView.addObject("items", user.getCart().getItems());
        modelAndView.addObject("cart", user.getCart());

        return modelAndView;
    }

    @RequestMapping(value = {"/cart/delete/{id}"}, method = RequestMethod.GET)
    public ModelAndView deleteItem(@PathVariable(value = "id") Integer id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.getUserByLogin(userName);

        Set<Item> items = removeItemInCart(id, user.getCart());

        user.getCart().setItems(items);
        cartService.updateCart(user.getCart());
        return cart();
    }

    @ResponseBody
    @RequestMapping(value = {"/cart/buy"})
    public String buy(@RequestBody String id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User user = userService.getUserByLogin(userName);
        Good good = goodService.getGoodById(Integer.valueOf(id));

        Cart cart = user.getCart();
        addGoodInCart(good, cart);
        cartService.updateCart(cart);

        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString("<b>" + good.getTitle() + "</b> been successfully added in your cart!");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Set<Item> removeItemInCart(Integer itemId, Cart cart) {
        Set<Item> items = cart.getItems();
        Item removeItem = null;
        for (Item item : items) {
            if (item.getGood().getId().equals(itemId)) {
                removeItem = item;
                for (int i = 0; item.getCount() > i; i++)
                    cart.setSum(cart.getSum() - removeItem.getGood().getPrice());
            }
        }
        if (removeItem != null)
            items.remove(removeItem);

        return items;
    }

    private void addGoodInCart(Good good, Cart cart) {
        Set<Item> items = cart.getItems();
        boolean flag = true;
        for (Item item : items) {
            if (item.getGood().equals(good)) {
                item.setCount(item.getCount() + 1);
                cart.setSum(cart.getSum() + good.getPrice());
                flag = false;
            }
        }
        if (flag) {
            Item newItem = new Item();
            newItem.setGood(good);
            newItem.setCart(cart);
            newItem.setCount(1);
            cart.setSum(cart.getSum() + good.getPrice());
            cart.addItem(newItem);
        }
    }

}

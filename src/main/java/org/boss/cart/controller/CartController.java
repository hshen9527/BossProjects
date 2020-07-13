package org.boss.cart.controller;

import org.boss.cart.model.cart.OrderItem;
import org.boss.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @ResponseBody
    @PostMapping("/add")
    public String add(@RequestBody OrderItem goods){
        cartService.add(goods);
        return "add goods info : " + goods.getItemName();
    }

    @ResponseBody
    @PostMapping("/remove")
    public String remove(@RequestBody OrderItem goods){
        cartService.remove(goods.getItemId());
        return "remove goods info: " + goods.getItemName();
    }

    @ResponseBody
    @PostMapping("/edit")
    public String edit(@RequestBody OrderItem goods){
        cartService.edit(goods.getItemId(), goods.getNumber());
        return null;
    }

    @ResponseBody
    @GetMapping("/list")
    public String list(){
        return cartService.list();
    }

}

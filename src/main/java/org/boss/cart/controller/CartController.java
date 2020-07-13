package org.boss.cart.controller;

import org.boss.cart.model.cart.Goods;
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
    public String add(@RequestBody Goods goods){
        cartService.add(goods);
        return "add goods info : " + goods.getName();
    }

    @ResponseBody
    @PostMapping("/remove")
    public String remove(@RequestBody Goods goods){
        cartService.remove(goods.getGoodId());
        return "remove goods info: " + goods.getName();
    }

    @ResponseBody
    @PostMapping("/edit")
    public String edit(@RequestBody Goods goods){
        cartService.edit(goods.getGoodId(), goods.getNumber());
        return null;
    }

    @ResponseBody
    @GetMapping("/list")
    public String list(){
        return cartService.list();
    }

}

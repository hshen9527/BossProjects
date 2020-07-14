package org.boss.cart.controller;

import org.boss.cart.model.cart.dto.GoodsDTO;
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
    public String add(@RequestBody GoodsDTO goods){
        cartService.add(goods);
        return "add goods info : " + goods.getName();
    }

    @ResponseBody
    @PostMapping("/remove")
    public String remove(@RequestBody GoodsDTO goods){
        cartService.remove(goods.getId());
        return "remove goods info: " + goods.getName();
    }

    @ResponseBody
    @PostMapping("/edit")
    public String edit(@RequestBody GoodsDTO goods){
        cartService.edit(goods.getId(), goods.getNumber());
        return null;
    }

    @ResponseBody
    @GetMapping("/list")
    public String list(){
        return cartService.list();
    }

}

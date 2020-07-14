package org.boss.cart.controller;

import org.boss.cart.model.cart.dto.OrderDTO;
import org.boss.cart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ResponseBody
    @PostMapping("/get")
    public OrderDTO getOrderByOrderId(@RequestParam("orderId") String orderId){
        OrderDTO order = orderService.getByOrderId(orderId);
        return order;
    }

    @PostMapping("/save")
    public boolean saveOrder(@RequestBody OrderDTO order){
        return orderService.save(order);
    }

}

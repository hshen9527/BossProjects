package org.boss.cart.controller;

import org.boss.cart.model.cart.Order;
import org.boss.cart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping("/getOrder")
    public Order getOrderByOrderId(@RequestParam("orderId") String orderId){
        Order order = orderService.getOrderByOrderID(orderId);
        order.setOrderItems(orderService.getOrderItems(orderId));
        return order;
    }

    @ResponseBody
    @RequestMapping("/get")
    public String getOrderByOrderId1(@RequestParam("orderId") String orderId){
        return orderId;
    }

}

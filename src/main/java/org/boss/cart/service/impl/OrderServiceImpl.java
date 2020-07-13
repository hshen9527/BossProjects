package org.boss.cart.service.impl;

import org.boss.cart.model.Order;
import org.boss.cart.model.OrderItem;
import org.boss.cart.persistence.OrderItemMapper;
import org.boss.cart.persistence.OrderMapper;
import org.boss.cart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private OrderMapper orderMapper;

    private List<OrderItem> orderItems;

    @Override
    public List<OrderItem> getOrderItems(String orderId) {
        return orderItemMapper.getOrderItems(orderId);
    }

    @Override
    public Order getOrderByOrderID(String orderId) {
        return orderMapper.getOrderByOrderID(orderId);
    }

    @Override
    public void setOrder(Order order) {

    }

    @Override
    public void updateOrder(Order order) {

    }
}

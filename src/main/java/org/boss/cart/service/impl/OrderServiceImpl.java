package org.boss.cart.service.impl;

import org.boss.cart.model.cart.Order;
import org.boss.cart.model.cart.OrderItem;
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

    // 获得订单商品
    @Override
    public List<OrderItem> getOrderItems(String orderId) {
        return orderItemMapper.getOrderItems(orderId);
    }

    // 获得订单抬头信息
    @Override
    public Order getOrderByOrderID(String orderId) {
        return orderMapper.getOrderByOrderID(orderId);
    }

    // 创建订单
    @Override
    public void setOrder(Order order) {

    }

    // 更新订单
    @Override
    public void updateOrder(Order order) {

    }
}

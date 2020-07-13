package org.boss.cart.service;

import org.apache.ibatis.annotations.Param;
import org.boss.cart.model.Order;
import org.boss.cart.model.OrderItem;

import java.util.List;

public interface OrderService {
    // 通过OrderId获得所有订单上物品
    List<OrderItem> getOrderItems(@Param("orderId") String orderId);

    Order getOrderByOrderID(@Param("orderId") String orderId);

    void setOrder(@Param("Order") Order order);

    void updateOrder(@Param("Order") Order order);
}

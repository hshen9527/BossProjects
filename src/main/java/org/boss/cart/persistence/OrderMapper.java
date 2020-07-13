package org.boss.cart.persistence;

import org.apache.ibatis.annotations.Param;
import org.boss.cart.model.cart.Order;

public interface OrderMapper {

    Order getOrderByOrderID(@Param("orderId") String orderId);

    void setOrder(@Param("Order") Order order);

    void updateOrder(@Param("Order") Order order);
    
}

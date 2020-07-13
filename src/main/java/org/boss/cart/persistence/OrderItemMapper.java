package org.boss.cart.persistence;

import org.apache.ibatis.annotations.Param;
import org.boss.cart.model.cart.OrderItem;

import java.util.List;

public interface OrderItemMapper {
    // 通过OrderId获得所有订单上物品
    List<OrderItem> getOrderItems(@Param("orderId") String orderId);
}

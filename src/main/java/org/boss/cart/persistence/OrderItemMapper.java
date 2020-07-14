package org.boss.cart.persistence;

import org.apache.ibatis.annotations.Param;
import org.boss.cart.model.cart.po.OrderItemPO;

import java.util.List;

public interface OrderItemMapper {

    /**
     * 通过OrderId获得所有订单上物品
     */
    List<OrderItemPO> listOrderItems(@Param("orderId") String orderId);

    /**
     * 插入Items信息
     * */
    void saveOrderItems(List<OrderItemPO> items);

}

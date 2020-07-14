package org.boss.cart.service;

import org.apache.ibatis.annotations.Param;
import org.boss.cart.model.cart.dto.OrderDTO;
import org.boss.cart.model.cart.po.OrderItemPO;

import java.util.List;

public interface OrderService {

    /**
     * 通过用户Id获得订单信息
     * */
    OrderDTO getByOrderId(String orderId);

    /**
     * 保存订单信息
     * */
    boolean save(OrderDTO order);
}

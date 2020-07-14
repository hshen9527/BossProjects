package org.boss.cart.persistence;

import org.apache.ibatis.annotations.Param;
import org.boss.cart.model.cart.dto.OrderDTO;
import org.boss.cart.model.cart.po.OrderInfoPO;

public interface OrderInfoMapper {

    /**
     * 通过orderId获得订单信息
     * */
    OrderInfoPO getOrderInfoByOrderID(@Param("orderId") String orderId);

    /**
     * 保存order抬头信息
     * */
    void saveOrderInfo(@Param("Order") OrderInfoPO orderInfo);

}

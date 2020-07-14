package org.boss.cart.service.impl;

import org.boss.cart.model.cart.dto.OrderDTO;
import org.boss.cart.model.cart.po.OrderInfoPO;
import org.boss.cart.model.cart.po.OrderItemPO;
import org.boss.cart.persistence.OrderItemMapper;
import org.boss.cart.persistence.OrderInfoMapper;
import org.boss.cart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private OrderInfoMapper orderInfoMapper;


    @Override
    public OrderDTO getByOrderId(String orderId) {
        return new OrderDTO(orderInfoMapper.getOrderInfoByOrderID(orderId), orderItemMapper.listOrderItems(orderId));
    }

    @Override
    public boolean save(OrderDTO order) {
        OrderInfoPO infoPO = new OrderInfoPO();
        infoPO.setOrderId(order.getOrderId());
        infoPO.setDepartment(order.getDepartment());
        infoPO.setApplicant(order.getApplicant());
        infoPO.setFilingDate(order.getFilingDate());
        orderInfoMapper.saveOrderInfo(infoPO);
        orderItemMapper.saveOrderItems(order.getOrderItems());
        return true;
    }
}

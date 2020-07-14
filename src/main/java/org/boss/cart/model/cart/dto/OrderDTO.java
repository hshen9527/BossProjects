package org.boss.cart.model.cart.dto;

import lombok.Data;
import org.boss.cart.model.cart.po.OrderInfoPO;
import org.boss.cart.model.cart.po.OrderItemPO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class OrderDTO implements Serializable {

    private String orderId;

    private String department;

    private String applicant;

    private Date filingDate;

    private List<OrderItemPO> orderItems;

    public OrderDTO(OrderInfoPO info, List<OrderItemPO> items){
        this.orderId = info.getOrderId();
        this.department = info.getDepartment();
        this.applicant = info.getApplicant();
        this.filingDate = info.getFilingDate();
        this.orderItems = items;
    }
}

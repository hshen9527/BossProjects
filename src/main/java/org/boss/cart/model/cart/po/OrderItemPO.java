package org.boss.cart.model.cart.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderItemPO implements Serializable {

    private String orderId;

    private long itemId;

    private String itemName;

    private String itemSize;

    private int number;

    private String purpose;

    private Date time;

}

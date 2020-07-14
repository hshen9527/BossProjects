package org.boss.cart.model.cart.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderInfoPO implements Serializable {

    private String orderId;

    private String department;

    private String applicant; //申请人

    private Date filingDate;

}

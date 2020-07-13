package org.boss.cart.model.cart;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {

    private String orderId;

    private String department_name;

    private String applicant; //申请人

    private Date application_date;

    private List<OrderItem> orderItems;

    public Order(){}

    // 创建订单
    public Order(String department_name, String applicant, Date application_date, List<OrderItem> orderItems){
        this.department_name = department_name;
        this.applicant = applicant;
        this.application_date = application_date;
        this.orderItems = orderItems;
        setOrderID();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Date getApplication_date() {
        return application_date;
    }

    public void setApplication_date(Date application_date) {
        this.application_date = application_date;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    // 生成订单ID
    public void setOrderID(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.orderId = df.format(new Date())+this.applicant;
    }
}

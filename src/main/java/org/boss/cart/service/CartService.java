package org.boss.cart.service;

import org.boss.cart.model.cart.OrderItem;

import java.util.HashMap;

public interface CartService {

    boolean add(OrderItem goods);

    boolean remove(long goodId);

    boolean edit(long goodsId, int number);

    String list();

    HashMap<Long, OrderItem> getCart();
}

package org.boss.cart.service;

import org.boss.cart.model.cart.dto.GoodsDTO;

import java.util.HashMap;

public interface CartService {

    boolean add(GoodsDTO goods);

    boolean remove(long goodId);

    boolean edit(long goodsId, int number);

    String list();

    HashMap<Long, GoodsDTO> getCart();

}

package org.boss.cart.service;

import org.boss.cart.model.cart.Goods;

import java.util.HashMap;

public interface CartService {

    // 添加商品
    boolean add(Goods goods);

    // 删除商品
    boolean remove(long goodId);

    // 修改商品数量
    boolean edit(long goodsId, int number);

    // 显示所有商品信息
    String list();

    // 获取购物车信息
    HashMap<Long, Goods> getCart();

}

package org.boss.cart.service.impl;

import org.boss.cart.model.cart.OrderItem;
import org.boss.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private HttpSession session;

    private HashMap<Long, OrderItem> myCart;

    @Override
    public boolean add(OrderItem goods) {
        getCart();
        //myCart.put(goods.getId(), goods);
        if(myCart.containsKey(goods.getItemId())){
            edit(goods.getItemId(), goods.getNumber()+1);
        }else {
            myCart.put(goods.getItemId(), goods);
        }
        return true;
    }

    @Override
    public boolean remove(long goodId) {
        getCart();
        myCart.remove(goodId);
        return true;
    }

    @Override
    public boolean edit(long goodsId, int number) {
        getCart();
        OrderItem goods = myCart.get(goodsId);
        goods.setNumber(number);
        return true;
    }

    @Override
    public String list() { // 显示内容
        getCart();
        return String.valueOf(myCart.entrySet().toArray());
    }

    @Override
    public HashMap<Long, OrderItem> getCart() {
        myCart = (HashMap)session.getAttribute("mycart"); // 获得session中的购物车信息
        if(myCart == null){
            myCart = new HashMap<Long, OrderItem>();
            session.setAttribute("myCart", myCart);
        }
        return myCart;
    }
}

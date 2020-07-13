package org.boss.cart.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.boss.cart.model.cart.Goods;
import org.boss.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private HttpSession session;

    private HashMap<Long, Goods> myCart;

    @Override
    public boolean add(Goods goods) {
        getCart();
        //myCart.put(goods.getId(), goods);
        if(myCart.containsKey(goods.getGoodId())){
            edit(goods.getGoodId(), goods.getNumber()+1);
        }else {
            myCart.put(goods.getGoodId(), goods);
        }
        return true;
    }

    @Override
    public boolean remove(long goodId) {
        getCart();
        if(myCart.containsKey(goodId)){
            myCart.remove(goodId);
        }else {
            return false;
        }
        return true;
    }

    @Override
    public boolean edit(long goodsId, int number) {
        getCart();
        Goods goods = myCart.get(goodsId);
        if(myCart.containsKey(goodsId)){
            if(number == 0){ // 商品数量为零则删除该商品
                remove(goodsId);
            }else {
                goods.setNumber(number);
            }
        }else {
            return false;
        }
        return true;
    }

    @Override
    public String list() { // 显示内容
        getCart();
        return JSONObject.toJSONString(myCart.entrySet().toArray());
    }

    // 创建订单
    public String settle() {
        //orderService.settleCart(getOwnerId());
        return "Cart Service Settled";
    }

    // 获得用户信息
    public long getOwnerId() {
        return 3003; //此处假使一个已存在用户ID
    }

    @Override
    public HashMap<Long, Goods> getCart() {
        myCart = (HashMap)session.getAttribute("mycart"); // 获得session中的购物车信息
        if(myCart == null){
            System.out.println("000");
            myCart = new HashMap<Long, Goods>();
            session.setAttribute("myCart", myCart);
        }
        return myCart;
    }
}

package org.boss.cart.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.boss.cart.model.cart.dto.GoodsDTO;
import org.boss.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Service
@Slf4j
public class CartServiceImpl implements CartService {

    @Autowired
    private HttpSession session;

    private HashMap<Long, GoodsDTO> myCart;

    @Override
    public boolean add(GoodsDTO goods) {
        getCart();
        //myCart.put(goods.getId(), goods);
        if(myCart.containsKey(goods.getId())){
            edit(goods.getId(), goods.getNumber()+1);
        }else {
            myCart.put(goods.getId(), goods);
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
        GoodsDTO goods = myCart.get(goodsId);
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
    public HashMap<Long, GoodsDTO> getCart() {
        myCart = (HashMap)session.getAttribute("mycart"); // 获得session中的购物车信息
        if(myCart == null){
            log.debug("session loading");
            myCart = new HashMap<Long, GoodsDTO>();
            session.setAttribute("myCart", myCart);
        }
        return myCart;
    }
}

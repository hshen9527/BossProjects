package org.boss.cart.service;

import org.apache.ibatis.annotations.Param;
import org.boss.cart.model.User;

import java.util.List;

public interface AccountService {

    // 获得所有用户信息
    List<User> getUserList();

    // 通过用户名得到登录密码信息
    User getUserInfoByUsername(@Param("username") String username);

    // 用来注册账号
    int setUser(@Param("username") String username,@Param("password") String password);

    // 用来修改密码
    int updateUser(@Param("username") String username, @Param("password") String password);

}

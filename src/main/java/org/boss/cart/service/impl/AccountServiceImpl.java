package org.boss.cart.service.impl;

import org.boss.cart.model.common.User;
import org.boss.cart.persistence.UserMapper;
import org.boss.cart.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public User getUserInfoByUsername(String username) {
        return userMapper.getUserInfoByUsername(username);
    }

    @Override
    public int setUser(String username, String password) {
        return userMapper.setUser(username, password);
    }

    @Override
    public int updateUser(String username, String password) {
        return userMapper.updateUser(username, password);
    }
}

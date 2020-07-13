package org.boss.cart.model;

import org.springframework.context.annotation.Bean;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "用户名称为:"+username+password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}

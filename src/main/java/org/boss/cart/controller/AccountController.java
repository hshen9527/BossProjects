package org.boss.cart.controller;

import org.boss.cart.model.User;
import org.boss.cart.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ResponseBody
    @GetMapping("/show")
    public List<User> getList(){
        return accountService.getUserList();
    }

    //@GetMapping("/verify/{username}")
    @ResponseBody
    @PostMapping("/verify")
    public boolean userVerify(@RequestParam(value = "username", required = true) String username,
                              @RequestParam(value = "password", required = true) String password){
        if(password.equals(accountService.getUserInfoByUsername(username).getPassword())){
            return true;
        }else {
            return false;
        }
    }

    @PostMapping("/logon")
    public boolean userLogon(@RequestParam(value = "username", required = true) String username,
                          @RequestParam(value = "password", required = true) String password){
         if(accountService.setUser(username, password)>0){
             return true;
         }else {
             return false;
         }
    }

    @ResponseBody
    @PostMapping("/modify")
    public boolean modifyUserInfo(@RequestParam(value = "username", required = true) String username,
                                  @RequestParam(value = "password", required = true) String password){
        if (accountService.updateUser(username,password)>0){
            return true;
        }else {
            return false;
        }
    }
}

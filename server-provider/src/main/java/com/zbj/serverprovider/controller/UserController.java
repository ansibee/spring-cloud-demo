package com.zbj.serverprovider.controller;

import com.zbj.serverprovider.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("getUser/{id}")
    public Object getUser(@PathVariable("id")Long id){
        User user = new User();
        user.setId(id);
        user.setName("曹操");
        return user;
    }
}

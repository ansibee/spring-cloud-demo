package com.zbj.serverconsumer.controller;

import com.zbj.serverconsumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "getUser/{uid}",produces = "application/json")
    public Object getUser(@PathVariable("uid")Long id){
        //调用远程服务 http请求
        User user = restTemplate.getForObject("http://localhost:8088/getUser/"+id,User.class);
        return user;
    }
}

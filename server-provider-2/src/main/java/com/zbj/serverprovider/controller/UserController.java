package com.zbj.serverprovider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zbj.serverprovider.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
public class UserController {

    @RequestMapping("getUserByFeign/{id}")
    @HystrixCommand(fallbackMethod = "getUserError")
    public Object getUserByFeign(@PathVariable("id")Long id){
        User user = new User();
        user.setId(id);
        user.setName("关羽");
        //int i = 1/0;
        return user;
    }

    public Object getUserError(Long id){
        String result =  id+"不存在";
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        map.put("result",result);
        return map;
    }

}

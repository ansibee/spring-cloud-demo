package com.zbj.serverconsumer.controller;

import com.zbj.serverprovider.feignClient.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserClient userClient;

    @RequestMapping("test")
    public String test(){
        return "ok";
    }

    @RequestMapping(value = "getUser/{uid}")
    public Object getUser(@PathVariable("uid")Long id){
        //调用远程服务 http请求
        //当我们的restTemplate加了注解@LoadBalanced之后，直接使用ip地址，那么就无法起到负载均衡的作用
        Object user = restTemplate.getForObject("http://localhost:8089/getUserByFeign/"+id,Object.class);
        return user;
    }

    @RequestMapping(value = "getUser2/{uid}",produces = "application/json")
    public Object getUser2(@PathVariable("uid")Long id){
        //通过服务名从注册中心获取服务列表,通过负载均衡调用
        //当我们的restTemplate加了注解@LoadBalanced之后，直接使用ip地址，那么就无法起到负载均衡的作用，
        //因为每次都是调用同一个服务，当你使用的是服务名称的时候，他会根据自己的算法去选择具有该服务名称的服务
        Object obj = restTemplate.getForObject("http://spring-cloud-demo-provider/getUserByFeign/"+id,Object.class);
        return obj;
    }

    @RequestMapping(value = "getUserByFeign/{uid}",produces = "application/json")
    public Object getUserByFeign(@PathVariable("uid")Long id){
        //调用远程服务 http请求
        return userClient.getUserByFeign(id);
    }
}

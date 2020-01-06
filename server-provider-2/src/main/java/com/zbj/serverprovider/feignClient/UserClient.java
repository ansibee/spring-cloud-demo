package com.zbj.serverprovider.feignClient;

//import com.zbj.serverprovider.feignClient.userClientFallback.UserClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "spring-cloud-demo-provider"/*,fallback = UserClientFallback.class*/)
public interface UserClient {

    @RequestMapping("getUserByFeign/{id}")
    Object getUserByFeign(@PathVariable("id")Long id);
}

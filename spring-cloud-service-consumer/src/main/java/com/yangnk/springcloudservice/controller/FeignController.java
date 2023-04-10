package com.yangnk.springcloudservice.controller;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-20 17:47
 **/

import com.yangnk.springcloudservice.remove.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-20 11:39
 **/
@RestController
public class FeignController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

    @GetMapping("/hello2")
    public String helloa() {
        String hello = helloService.hello2();
        System.out.println(hello);
        return hello;
    }
}

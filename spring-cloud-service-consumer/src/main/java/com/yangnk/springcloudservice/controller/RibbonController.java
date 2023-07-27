package com.yangnk.springcloudservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-20 17:03
 **/
@RestController
public class RibbonController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hello1")
    public String hello2() {
        return restTemplate.getForObject("http://spring-cloud-service-producer/hello1", String.class);
    }
}

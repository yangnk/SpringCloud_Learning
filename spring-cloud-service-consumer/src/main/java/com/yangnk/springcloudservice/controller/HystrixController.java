package com.yangnk.springcloudservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-21 14:43
 **/

@RestController
public class HystrixController {
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    //服务降级
    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/hello3")
    public String hello3() {
        return restTemplate.getForObject("http://spring-cloud-service-producer/hello3", String.class);
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    }) //开启，10次，10s， 60%
    @GetMapping("/hello4")
    public String hello4() {
        return restTemplate.getForObject("http://spring-cloud-service-producer/hello4", String.class);
    }

    public String fallback() {
        return "fallback";
    }
}

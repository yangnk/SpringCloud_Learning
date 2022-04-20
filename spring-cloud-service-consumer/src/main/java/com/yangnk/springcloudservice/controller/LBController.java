package com.yangnk.springcloudservice.controller;

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
public class LBController {
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

//    @GetMapping("/hello2")
//    public String hello2() {
//        ServiceInstance serviceInstance = loadBalancerClient.choose("SPRING-CLOUD-SERVICE");
//        System.out.println("====================");
//        System.out.println(serviceInstance);
//        System.out.println("====================");
//
//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hello";
//        System.out.println("====================");
//        System.out.println(url);
//        System.out.println("====================");
//        return restTemplate.getForObject(url, String.class);
//    }
    @GetMapping("/hello2")
    public String hello4() {

        return restTemplate.getForObject("http://spring-cloud-service-producer/hello2", String.class);
    }
}

package com.yangnk.springcloudservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-20 11:39
 **/
@RestController
public class HelloController {

    @Autowired
    DiscoveryClient discoveryClient;

    /**
     * 自己服务测试的接口
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
//        String services = "Services: " + discoveryClient.getServices();
        System.out.println("====================");
        System.out.println("hello");
        System.out.println("====================");
        return "hello";
    }

    /**
     * ribbon 服务调用测试
     * @return
     */
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello1() {
        System.out.println("====================");
        System.out.println("hello1");
        System.out.println("====================");
        return "hello1";
    }

    /**
     * feign 服务调用测试
     * @return
     */
    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String hello2() {
        System.out.println("====================");
        System.out.println("hello2");
        System.out.println("====================");
        return "hello2";
    }

    /**
     * hystrix 服务降级测试
     * @return
     * @throws InterruptedException
     */
    @RequestMapping(value = "/hello3", method = RequestMethod.GET)
    public String hello3() throws InterruptedException {
        Thread.sleep(100000);
        System.out.println("====================");
        System.out.println("hello3");
        System.out.println("====================");
        return "hello3";
    }
}
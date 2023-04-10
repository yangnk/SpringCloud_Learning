//package com.yangnk.springcloudservice.controller;
//
//import com.netflix.discovery.converters.Auto;
//import com.yangnk.springcloudservice.remove.Hello100RemoveService;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class Feign100Controller {
//    @Auto
//    Hello100RemoveService hello100RemoveService;
//
//    @RequestMapping(value = "hello100", method = RequestMethod.GET)
//    public String sayHello100() {
//        String hello100 = hello100RemoveService.hello100();
//        return hello100;
//    }
//}

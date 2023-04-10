package com.yangnk.springcloudservice.remove;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-20 12:01
 **/

@FeignClient(url = "127.0.0.1:8083", name = "spring-cloud-service-producer")
public interface HelloService {

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    String hello2();
}

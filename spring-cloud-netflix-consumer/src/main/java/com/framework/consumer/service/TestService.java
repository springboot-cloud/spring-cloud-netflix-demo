package com.framework.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: 消费端测试服务相关
 * @author: XiongFeiYang
 * @createTime: 2019-08-17 01:25
 **/
@RequestMapping("/provider")
@FeignClient(value = "spring-cloud-netflix-provider")
public interface TestService {

    @GetMapping("/hi")
    String sayHello(@RequestParam("massage") String massage);

}

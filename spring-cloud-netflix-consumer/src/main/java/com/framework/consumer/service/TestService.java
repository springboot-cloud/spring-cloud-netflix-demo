package com.framework.consumer.service;

import com.framework.consumer.service.hystrix.TestServiceHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: 消费端测试服务相关
 * @author: XiongFeiYang
 * @createTime: 2019-08-17 01:25
 **/
@RequestMapping("/provider")
@FeignClient(value = "spring-cloud-netflix-provider", fallback = TestServiceHystrixImpl.class)
public interface TestService {

    /**
     * 测试
     * @param message message
     * @return String
     */
    @GetMapping("/hi")
    String sayHello(@RequestParam("message") String message);

    /**
     * 测试
     * @param name name
     * @return String
     */
    @GetMapping("/hi/{name}")
    String sayHi(@PathVariable("name") String name);

}

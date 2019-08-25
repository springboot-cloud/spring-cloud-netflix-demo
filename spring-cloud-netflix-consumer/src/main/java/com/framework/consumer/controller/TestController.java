package com.framework.consumer.controller;

import com.framework.consumer.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 消费端测试请求入口
 * @author: XiongFeiYang
 * @createTime: 2019-08-17 01:27
 **/
@Api("消费端测试请求入口")
@RestController
@RequestMapping("/consumer")
public class TestController {

    @Autowired
    private TestService testService;

    @ApiOperation("测试方法")
    @GetMapping("/hi")
    public String sayHello(String message){
        return testService.sayHello(message);
    }

    @ApiOperation("测试方法")
    @GetMapping("/hi/{name}")
    public String sayHi(@PathVariable("name") String name){
        return testService.sayHi(name);
    }

}

package com.framework.provider.controller;

import com.framework.provider.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 提供者测试请求入口
 * @author: XiongFeiYang
 * @createTime: 2019-08-17 00:06
 **/
@Api(description = "提供者测试请求入口")
@RestController
@RequestMapping("/provider")
public class TestController {

    @Autowired
    private TestService testService;

    @ApiOperation("测试方法")
    @GetMapping("/hi")
    public String sayHello(String massage){
        return testService.sayHello(massage);
    }

}

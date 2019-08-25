package com.framework.consumer.service.hystrix;

import com.framework.consumer.service.TestService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 消费端测试服务相关熔断器
 * @author: XiongFeiYang
 * @createTime: 2019-08-17 10:05
 **/
@Component
@RequestMapping("/provider/error")
public class TestServiceHystrixImpl implements TestService {

    @Override
    public String sayHello(String message) {
        return String.format("Hi your message is %s but request error", message);
    }

    @Override
    public String sayHi(String name) {
        return String.format("Hi your name is %s but request error", name);
    }
}

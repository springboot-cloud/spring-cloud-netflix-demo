package com.framework.provider.service.impl;

import com.framework.provider.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @description: 测试服务相关实现
 * @author: XiongFeiYang
 * @createTime: 2019-08-17 00:12
 **/
@Service
public class TestServiceImpl implements TestService {

    @Value("${server.port}")
    private String port;

    @Override
    public String sayHello(String massage) {
        return String.format("Hi，your massage is : %s i am from port : %s", massage, port);
    }
}

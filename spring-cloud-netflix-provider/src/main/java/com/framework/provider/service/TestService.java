package com.framework.provider.service;

/**
 * @description: 测试服务相关
 * @author: XiongFeiYang
 * @createTime: 2019-08-17 00:09
 **/
public interface TestService {

    /**
     * 测试
     * @param message message
     * @return String
     */
    String sayHello(String message);

    /**
     * 测试
     * @param name name
     * @return String
     */
    String sayHi(String name);

}

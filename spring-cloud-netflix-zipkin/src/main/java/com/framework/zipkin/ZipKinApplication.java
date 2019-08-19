package com.framework.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.internal.EnableZipkinServer;

/**
 * @description: SpringCloud 服务链路追踪  Zipkin启动类
 * @author: XiongFeiYang
 * @createTime: 2019-08-19 20:38
 **/
@EnableZipkinServer
@EnableEurekaClient
@SpringBootApplication
public class ZipKinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipKinApplication.class, args);
    }

}

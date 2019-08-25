package com.framework.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description: SpringBoot Admin 服务端启动类
 * @author: XiongFeiYang
 * @createTime: 2019-08-20 23:03
 **/
@EnableAdminServer
@EnableEurekaClient
@SpringBootApplication
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}

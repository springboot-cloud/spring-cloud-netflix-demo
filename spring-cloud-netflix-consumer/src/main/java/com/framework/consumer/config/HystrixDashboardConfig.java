package com.framework.consumer.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 消费端熔断器仪表盘监控配置
 * @author: XiongFeiYang
 * @createTime: 2019-08-17 10:13
 **/
@Configuration
public class HystrixDashboardConfig {

    @Bean
    public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet() {
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(new HystrixMetricsStreamServlet());
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}

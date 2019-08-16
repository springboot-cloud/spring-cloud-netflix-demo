package com.framework.provider.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description: Swagger配置类
 * @author: XiongFeiYang
 * @createTime: 2019-08-17 00:22
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${server.port}")
    private String port;

    @Value("${swagger.base.package}")
    private String basePackage;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringCloud Netflix 服务提供者")
                .description("SpringCloud Netflix 服务提供者")
                .termsOfServiceUrl("localhost:" + port)
                .contact(new Contact("服务提供者", "localhost:" + port + "/swagger-ui.html", "email@example.com"))
                .version("1.0")
                .build();
    }

}

package com.internet.mind.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${sop.swagger.host}")
    private String host;

    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host(host)
                .groupName("王子轩")
                .apiInfo(apiInfo1())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.internet.mind.controller"))
                .build();
    }

    /*@Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("test")
                //.apiInfo(apiInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.none())
                .build();
    }*/

    private ApiInfo apiInfo1() {
        Contact contact = new Contact("王子轩","http://blog.wzixuan.com/","8541152891@163.com");
        return new ApiInfo(
                "互联网+竞赛项目API文档",
                "Mind-用心打造_互联网+",
                "v1.0",
                "http://www.wzixuan.com/mind",
                contact,
                "Apache 2.0",
                "http://www.apache.org/locenses/LICENSE-2.0",
                new ArrayList()
        );
    }
}

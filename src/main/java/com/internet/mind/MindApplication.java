package com.internet.mind;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan(value = "com.internet.mind.mapper")
@ConfigurationPropertiesScan
@SpringBootApplication
public class MindApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MindApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MindApplication.class);
    }
}

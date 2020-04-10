package com.qsqx.activemqdemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "person")
@Data
public class Person {
    private String name;
    private String gender;
    private String age;
}

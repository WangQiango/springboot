package com.spring.at.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;

//作为配置类 替代spring配置文件
@Configuration
@ComponentScan(basePackages = "com.spring.at")
public class SpringConfig {

}

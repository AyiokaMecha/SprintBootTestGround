package com.danmecha.dependencyInjection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    @Qualifier("bean1")
    public MyFirstClass myFirsBean() {
        return new MyFirstClass("FirstBean");
    }
}

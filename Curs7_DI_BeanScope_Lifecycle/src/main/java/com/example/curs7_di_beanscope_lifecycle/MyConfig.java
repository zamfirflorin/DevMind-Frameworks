package com.example.curs7_di_beanscope_lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public WebDevTeacher webDevTeacher() {
        return new WebDevTeacher();
    }

}

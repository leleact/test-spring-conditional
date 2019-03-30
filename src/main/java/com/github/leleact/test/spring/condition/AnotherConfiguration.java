package com.github.leleact.test.spring.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnotherConfiguration {

    @Bean
    public static ConditionalBean conditionalBean() {
        return new ConditionalBean();
    }
}

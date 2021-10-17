package com.vsiestov;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.vsiestov"})
public class SpringConfig {

    @Bean
    public NameProvider getNameProviders() {
        return new NameProvider();
    }
}

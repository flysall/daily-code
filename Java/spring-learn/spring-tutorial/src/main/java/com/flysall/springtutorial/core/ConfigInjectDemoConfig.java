package com.flysall.springtutorial.core;

import org.springframework.context.annotation.*;

@Configuration
public class ConfigInjectDemoConfig {
    @Bean
    public ConfigInjectDemo configInject() {
        return new ConfigInjectDemo();
    }
}

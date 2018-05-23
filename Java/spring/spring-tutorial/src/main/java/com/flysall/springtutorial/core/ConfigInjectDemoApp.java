package com.flysall.springtutorial.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigInjectDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigInjectDemoConfig.class);
        ConfigInjectDemo configInjectDemo = ctx.getBean(ConfigInjectDemo.class);
        configInjectDemo.setMessage("configInjectDemo.setMessage()");
        System.out.println(configInjectDemo.getMessage());
    }
}

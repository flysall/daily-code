package com.flysall.springtutorial.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigLifeCycleDemoApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ConfigLifeCycleDemo objOne = ctx.getBean(ConfigLifeCycleDemo.class);
        ConfigLifeCycleDemo objTwo = ctx.getBean(ConfigLifeCycleDemo.class);
        System.out.print("objOne == objTwo is " + (objOne == objTwo));
    }
}

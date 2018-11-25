package com.flysall.springtutorial.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeDemoApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        BeanLifeDemo beanLifeDemo = (BeanLifeDemo) context.getBean("beanLifeDemo");
        String message = beanLifeDemo.getMessage();
        context.registerShutdownHook();
    }
}

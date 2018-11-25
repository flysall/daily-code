package com.flysall.springtutorial.core;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomEventApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");

        CustomEventPublisher cvp = (CustomEventPublisher) ctx.getBean("customEventPublisher");
        cvp.publish();
        cvp.publish();
    }
}

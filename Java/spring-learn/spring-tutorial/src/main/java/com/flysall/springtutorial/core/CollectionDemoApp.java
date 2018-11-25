package com.flysall.springtutorial.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionDemoApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        CollectionDemo collectionDemo = (CollectionDemo) context.getBean("collectionDemo");
        System.out.println(collectionDemo.getAddressList());
        System.out.println(collectionDemo.getAddressSet());
        System.out.println(collectionDemo.getAddressMap());
        System.out.print(collectionDemo.getAddressProp());
    }
}

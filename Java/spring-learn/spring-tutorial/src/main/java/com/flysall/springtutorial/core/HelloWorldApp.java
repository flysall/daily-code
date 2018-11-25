package com.flysall.springtutorial.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld helloWorldObjOne = (HelloWorld) context.getBean("helloWorld");
        HelloWorld helloWorldObjTwo = (HelloWorld) context.getBean("helloWorld");
        String message = helloWorldObjOne.getMessage();
        System.out.println(message);
        System.out.println("helloWorldObjOne == helloWorldObjTwo is " + (helloWorldObjOne == helloWorldObjTwo) + " when bean scope is prototype");
    }
}
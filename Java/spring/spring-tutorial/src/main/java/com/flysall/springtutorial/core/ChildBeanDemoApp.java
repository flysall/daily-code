package com.flysall.springtutorial.core;

import javafx.scene.Parent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ChildBeanDemoApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        ParentBeanDemo parentBeanDemo = (ParentBeanDemo) context.getBean("parentBeanDemo");
        System.out.println(parentBeanDemo.getMessage1());
        System.out.println(parentBeanDemo.getMessage2());

        ChildBeanDemo childBeanDemo = (ChildBeanDemo) context.getBean("childBeanDemo");
        System.out.println(childBeanDemo.getMessage1());
        System.out.println(childBeanDemo.getMessage2());
        System.out.println(childBeanDemo.getMessage3());
    }
}

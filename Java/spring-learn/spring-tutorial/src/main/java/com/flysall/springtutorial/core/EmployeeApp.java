package com.flysall.springtutorial.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeApp {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        EmployeeController controller = context.getBean(EmployeeController.class);
        controller.createNewEmployee();
    }
}

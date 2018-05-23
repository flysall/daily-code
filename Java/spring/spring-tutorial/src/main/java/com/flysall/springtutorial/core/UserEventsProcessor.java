package com.flysall.springtutorial.core;

import org.springframework.context.ApplicationListener;

public class UserEventsProcessor implements ApplicationListener<EmployeeEvent> {
    @Override
    public void onApplicationEvent(EmployeeEvent event) {
        EmployeeEvent employeeEvent = (EmployeeEvent) event;
        System.out.println("Employee " + employeeEvent.getEventType() +
            " with details : " + employeeEvent.getEmployee());
    }
}

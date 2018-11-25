package com.flysall.springtutorial.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service("employeeManager")
public class EmployeeManagerImpl implements EmployeeManager, ApplicationEventPublisherAware {
    @Autowired
    private EmployeeDAO dao;

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public EmployeeDTO createNewEmployee() {
        EmployeeDTO employee = dao.createNewEmployee();
        // Publish the event here.
        publisher.publishEvent(new EmployeeEvent(this, "ADD", employee));
        return employee;
    }
}

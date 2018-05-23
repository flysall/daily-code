package com.flysall.springtutorial.core;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public EmployeeDTO createNewEmployee() {
        EmployeeDTO e = new EmployeeDTO();
        e.setId(1);
        e.setFirstName("Lokesh");
        e.setLastName("Gupta");
        return e;
    }

    public void initBean() {
        System.out.println("Init Bean for : EmployeeDAOImpl");
    }

    public void destroyBean() {
        System.out.println("Destroy Bean for : EmployeeDAOImpl");
    }
}

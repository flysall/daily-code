package com.flysall.junitlearn;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestEmployeeDetails {
    EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
    EmployeeDetails employee = new EmployeeDetails();
    {
        employee.setName("Rajeev");
        employee.setAge(25);
        employee.setMonthlySalary(8000);
    }

    @Test
    public void testCalculateAppriasal() {
        double appraisal = empBusinessLogic.calculateAppraisal(employee);
        assertEquals(500, appraisal, 0.0);
    }

    @Test
    public void tesCalculateYearlySalary() {
        double salary = empBusinessLogic.calculateYearSalary(employee);
        assertEquals(96000, salary, 0.0);
    }
}

package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void getIdMethodReturnsEmployeeId() {
        Employee employee = new Employee("1",50000);

        var employeeId = employee.getId();

        assertEquals("1", employeeId);
    }

    @Test
    void setIdSetsUpdatedEmployeeId() {
        Employee employee = new Employee("1",50000);
        employee.setId("2");

        var employeeId = employee.getId();

        assertEquals("2", employeeId);
    }

    @Test
    void getSalaryReturnsEmployeesSalary() {
        Employee employee = new Employee("1",50000);

        var employeeSalary = employee.getSalary();

        assertEquals(50000, employeeSalary);
    }

    @Test
    void setSalarySetsUpdatedEmployeeSalary() {
        Employee employee = new Employee("1",50000);
        employee.setSalary(25000);

        var employeeSalary = employee.getSalary();

        assertEquals(25000, employeeSalary);
    }

    @Test
    void isPaidReturnsTrueWhenSalaryPaidSetToTrue() {
        Employee employee = new Employee("1",50000);
        employee.setPaid(true);

        var salaryPaid = employee.isPaid();

        assertTrue(salaryPaid);
    }

    @Test
    void isPaidReturnsFalseWhenSalaryPaidSetToFalse() {
        Employee employee = new Employee("1",50000);
        employee.setPaid(false);

        var salaryPaid = employee.isPaid();

        assertFalse(salaryPaid);
    }

    @Test
    void setPaidSetsTheSalaryToTrue() {
        Employee employee = new Employee("1",50000);
        employee.setPaid(true);

        var isSalaryPaid = employee.isPaid();

        assertTrue(isSalaryPaid);
    }

    @Test
    void setPaidSetsTheSalaryToFalse() {
        Employee employee = new Employee("1",50000);
        employee.setPaid(false);

        var isSalaryPaid = employee.isPaid();

        assertFalse(isSalaryPaid);
    }

    @Test
    void testToString() {
        Employee newEmployee = new Employee("abc", 35000);

        var expected = "Employee [id=" + newEmployee.getId() + ", salary=" + newEmployee.getSalary() + "]";

        assertEquals(expected, newEmployee.toString());
    }
}
package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private Employee employee;

    @BeforeEach
    public void setUp() {
        this.employee = new Employee("Saher01",50000);
    }

    @AfterEach
    public void tearDown() {
        this.employee = null;
    }

    @Test
    void getIdMethodReturnsEmployeeId() {
        //Employee employee = new Employee("1",50000);

        var employeeId = employee.getId();

        assertEquals("Saher01", employeeId);
    }

    @Test
    void setIdSetsUpdatedEmployeeId() {
        //Employee employee = new Employee("1",50000);
        employee.setId("Ismail01");

        var employeeId = employee.getId();

        assertEquals("Ismail01", employeeId);
    }

    @Test
    void getSalaryReturnsEmployeesSalary() {
        //Employee employee = new Employee("1",50000);

        var employeeSalary = employee.getSalary();

        assertEquals(50000, employeeSalary);
    }

    @Test
    void setSalarySetsUpdatedEmployeeSalary() {
        //Employee employee = new Employee("1",50000);
        employee.setSalary(25000);

        var employeeSalary = employee.getSalary();

        assertEquals(25000, employeeSalary);
    }

    @Test
    void isPaidReturnsTrueWhenSalaryPaidSetToTrue() {
        //Employee employee = new Employee("1",50000);
        employee.setPaid(true);

        var salaryPaid = employee.isPaid();

        assertTrue(salaryPaid);
    }

    @Test
    void isPaidReturnsFalseWhenSalaryPaidSetToFalse() {
        //Employee employee = new Employee("1",50000);
        employee.setPaid(false);

        var salaryPaid = employee.isPaid();

        assertFalse(salaryPaid);
    }

    @Test
    void setPaidSetsTheSalaryToTrue() {
        //Employee employee = new Employee("1",50000);
        employee.setPaid(true);

        var isSalaryPaid = employee.isPaid();

        assertTrue(isSalaryPaid);
    }

    @Test
    void setPaidSetsTheSalaryToFalse() {
        //Employee employee = new Employee("1",50000);
        employee.setPaid(false);

        var isSalaryPaid = employee.isPaid();

        assertFalse(isSalaryPaid);
    }

    @Test
    void testToString() {
        //Employee newEmployee = new Employee("abc", 35000);

        var expected = "Employee [id=" + employee.getId() + ", salary=" + employee.getSalary() + "]";

        assertEquals(expected, employee.toString());
    }
}
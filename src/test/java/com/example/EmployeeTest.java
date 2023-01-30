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
        assertEquals("Saher01", employee.getId());
    }

    @Test
    void setIdSetsUpdatedEmployeeId() {
        employee.setId("Ismail01");

        assertEquals("Ismail01", employee.getId());
    }

    @Test
    void getSalaryReturnsEmployeesSalary() {
        assertEquals(50000, employee.getSalary());
    }

    @Test
    void setSalarySetsUpdatedEmployeeSalary() {
        employee.setSalary(25000);

        assertEquals(25000, employee.getSalary());
    }

    @Test
    void isPaidReturnsTrueWhenSalaryPaidSetToTrue() {
        employee.setPaid(true);

        assertTrue(employee.isPaid());
    }

    @Test
    void isPaidReturnsFalseWhenSalaryPaidSetToFalse() {
        employee.setPaid(false);

        assertFalse(employee.isPaid());
    }

    @Test
    void setPaidSetsTheSalaryToTrue() {
        employee.setPaid(true);

        assertTrue(employee.isPaid());
    }

    @Test
    void setPaidSetsTheSalaryToFalse() {
        employee.setPaid(false);

        assertFalse(employee.isPaid());
    }

    @Test
    void testToString() {
        var expected = "Employee [id=" + employee.getId() + ", salary=" + employee.getSalary() + "]";

        assertEquals(expected, employee.toString());
    }
}
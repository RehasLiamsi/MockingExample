package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;

class EmployeesTest {

    EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
    BankService bankService = Mockito.mock(BankService.class);

    Employees employees = new Employees(employeeRepository, bankService);

    Employee firstEmployee = new Employee("Saher1", 15000);


    @Test
    @DisplayName("Paying one employ should return 1 payment")
    void payOneEmployeeShouldIncreasePaymentForEmployeeByOne() {
        employeeRepository.save(firstEmployee);
        assertEquals(1, employees.payEmployees());
    }

    @Test
    @DisplayName("Paying two employees should return 2 payments")
    void payTwoEmployeesIncreasesPaymentForEmployeesByTwo() {
        Employee secondEmployee = new Employee("Ismail2", 30000);

        employeeRepository.save(firstEmployee);
        employeeRepository.save(secondEmployee);

        assertEquals(2, employees.payEmployees());
    }

    @Test
    @DisplayName("Pay Employee method should throw exception")
    void payEmployeesThrowsRunTimeException() {
        doThrow(new RuntimeException()).when(bankService).pay(anyString(), anyDouble());

        employeeRepository.save(firstEmployee);

        employees.payEmployees();
        assertFalse(firstEmployee.isPaid());
    }

}
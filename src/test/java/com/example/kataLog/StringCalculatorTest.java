package com.example.kataLog;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @DisplayName("Add method adds two numbers")
    @ParameterizedTest(name = "{index} ==> {0} added together is {1}")
    @CsvSource({
            "'',0",
            "'0,1',1",
            "1,1",
            "'1,1', 2"
    })
    void addReturnsTheSumOfTheTwoNumbersSent(String numbers, int expected) {
        int result = StringCalculator.Add(numbers);
        assertEquals(expected, result);
    }
}

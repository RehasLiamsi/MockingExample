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

    @DisplayName("Add method adds unlimited numbers")
    @ParameterizedTest(name = "{index} ==> {0} added together is {1}")
    @CsvSource({
            "1,1",
            "'1,1', 2",
            "'9,8,7', 24",
            "'1,2,3,4',10"
    })
    void addReturnsTheSumOfUnlimitedNumbersSent(String numbers, int expected) {
        int result = StringCalculator.Add(numbers);
        assertEquals(expected, result);
    }

    @DisplayName("Add method can handle line breaks between numbers")
    @ParameterizedTest(name = "{index} ==> {0} added together is {1}")
    @CsvSource({
            "'1\n1', 2",
            "'9\n8,7', 24",
            "'1,2\n3,4',10"
    })
    void addHandlesLineBreaksBetweenNumbers(String numbers, int expected) {
        int result = StringCalculator.Add(numbers);
        assertEquals(expected, result);
    }
    @DisplayName("Add method can handle custom delimiters input between // and line break")
    @ParameterizedTest(name = "{index} ==> {0} added together is {1}")
    @CsvSource({
            "'1,1', 2",
            "'9\n8,7', 24",
            "'//;\n1;2', 3"
    })
    void addHandlesCustomDelimitersBetweenNumbers(String numbers, int expected) {
        int result = StringCalculator.Add(numbers);
        assertEquals(expected, result);

}
}

package com.example.kataLog;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @DisplayName("Empty string returns 0")
    @Test
    void addReturnsZeroWhenEmptyStringIsEntered(){
        int result = StringCalculator.Add("");
        assertEquals(0, result);
    }

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
    @Test
    void addHandlesLineBreaksBetweenNumbers() {
        int result = StringCalculator.Add("9\n8,7");
        assertEquals(24, result);
    }

    @DisplayName("Add method can handle custom delimiters input between // and line break")
    @Test
    void addHandlesCustomDelimitersBetweenNumbers() {
        int result = StringCalculator.Add("//;\n1;2");
        assertEquals(3, result);

}

    @DisplayName("Add method throws exception if negative number is entered")
    @Test
    void addThrowsExceptionWhenNegativeValueEntered() {
       assertThatThrownBy(() -> StringCalculator.Add("-9,3"))
               .isInstanceOf(IllegalArgumentException.class)
               .hasMessageContaining("Negatives not allowed: [-9]");

    }

    @DisplayName("Add method ignores numbers greater than 1000")
    @Test
    void addIgnoresNumbersGreaterThan1000(){
        int result = StringCalculator.Add("2,1001");
        assertEquals(2,result);
    }

    @DisplayName("Delimiters of any length are accepted")
    @Test
    void addAcceptsDelimitersOfAnyLength() {
        int result = StringCalculator.Add("//[***]\n1***2***3");
        assertEquals(6,result);
    }

    @DisplayName("Multiple delimiters are accepted")
    @Test
    void addAcceptsMultipleDelimiters() {
        int result = StringCalculator.Add("//[*][%]\n1*2%3");
        assertEquals(6, result);
    }

    @DisplayName("Multiple delimiters with any length are accepted")
    @Test
    void addAcceptsMultipleDelimitersWithLengthLongerThanOneChar() {
        int result = StringCalculator.Add("//[...][,,,]\n1...2,,,3");
        assertEquals(6, result);
    }
}

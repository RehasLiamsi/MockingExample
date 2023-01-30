package com.example.kataLog;

import java.util.Arrays;

public class StringCalculator {

    private String delimiter;
    private String numbers;

    private StringCalculator(String delimiter, String numbers) {
        this.delimiter = delimiter;
        this.numbers = numbers;
    }
    public static int Add(String inputNumber) {
        if (inputNumber.isEmpty())
            return 0;

        StringCalculator calculator = parseInput(inputNumber);

        return calculator.getSum();
        }

    private int getSum() {
        return Arrays.stream(numbers.split(delimiter))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static StringCalculator parseInput(String inputNumber) {
        StringCalculator calculator;
        if (inputNumber.startsWith("//")) {
            String[] parts = inputNumber.split("\n",2);
            return new StringCalculator(parts[0].substring(2),parts[1]);
        } else {
            return new StringCalculator("[,\n]", inputNumber);
        }
    }
}

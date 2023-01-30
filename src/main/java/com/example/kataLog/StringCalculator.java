package com.example.kataLog;

import java.util.Arrays;

public class StringCalculator {
    public static int Add(String numbers) {
        if (numbers.isEmpty())
            return 0;
        else {
           int sum = Arrays.stream(numbers.split("[,\n]"))
                   .mapToInt(Integer::parseInt)
                   .sum();
           return sum;
        }
    }
}

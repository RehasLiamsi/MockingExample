package com.example.kataLog;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {

    private String delimiter;
    private String numbers;

    private StringCalculator(String delimiter, String numbers) {
        this.delimiter = delimiter;
        this.numbers = numbers;
    }

    public static int Add(String inputNumber) {
        if (inputNumber.isEmpty()) {
            return 0;
        }

        StringCalculator calculator = parseInput(inputNumber);

        return calculator.getSum();
    }

    private int getSum() {
        findNegativeNumbers();
        return getIntStream()
                .sum();
    }

    private void findNegativeNumbers() {
        String negativeNumbers = getIntStream()
                .filter(n -> n < 0)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: [" + negativeNumbers + "]");
        }
    }

    private IntStream getIntStream() {
        return Arrays.stream(numbers.split(delimiter))
                .mapToInt(Integer::parseInt).filter(n -> n <= 1000);
    }

    private static StringCalculator parseInput(String inputNumber) {
        StringCalculator calculator;
        if (inputNumber.startsWith("//")) {
            String[] parts = inputNumber.split("\n", 2);
            return new StringCalculator(parseDelimiter(parts), parts[1]);
        } else {
            return new StringCalculator("[,|\n]", inputNumber);
        }
    }

    private static String parseDelimiter(String[] parts) {
        String delimiter = parts[0].substring(2);
        if (delimiter.startsWith("[")) {
            delimiter = delimiter.substring(1, delimiter.length() - 1);
            return Stream.of(delimiter.split("]\\["))
                    .map(Pattern::quote)
                    .collect(Collectors.joining("|"));
        }
        return Pattern.quote(delimiter);
    }
}

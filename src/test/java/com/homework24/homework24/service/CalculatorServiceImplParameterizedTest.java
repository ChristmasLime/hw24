package com.homework24.homework24.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorServiceImplParameterizedTest {

    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(2.0, 4.0),
                Arguments.of(-666.0, 7.0),
                Arguments.of(514.0, 44.0),
                Arguments.of(78.0, 6.0),
                Arguments.of(9.0, 64.0)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testPlus(double a, double b) {
        String expected = "Результат сложения : " + a + " + " + b + " = " + (a + b);
        String actual = calculatorService.plus(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testMinus(double a, double b) {
        String expected = "Результат вычитания : " + a + " - " + b + " = " + (a - b);
        String actual = calculatorService.minus(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testMultiply(double a, double b) {
        String expected = "Результат умножения : " + a + " * " + b + " = " + (a * b);
        String actual = calculatorService.multiply(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testDivide(double a, double b) {
        if (b != 0) {
            String expected = "Результат деления : " + a + " / " + b + " = " + (a / b);
            String actual = calculatorService.divide(a, b);
            Assertions.assertEquals(expected, actual);
        } else {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                calculatorService.divide(a, b);
            });
        }
    }
}


package com.homework24.homework24.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculateServiceImplParameterizedTest {

    private final CalculateServiceImpl calculatorService = new CalculateServiceImpl();

    private static Stream<Arguments> plusData() {
        return Stream.of(
                Arguments.of(2.0, 4.0, 6.0),
                Arguments.of(-47.0, 7.0, -40.0),
                Arguments.of(544.0, 44.0, 588.0),
                Arguments.of(78.0, 6.0, 84.0),
                Arguments.of(9.0, 64.0, 73.0)
        );
    }

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
    @MethodSource("plusData")
    public void testPlus(double a, double b, double expected) {
        double actual = calculatorService.plus(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testMinus(double a, double b) {
        double expected = a - b;
        double actual = calculatorService.minus(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testMultiply(double a, double b) {
        double expected = a * b;
        double actual = calculatorService.multiply(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testDivide(double a, double b) {
        double expected = a / b;
        double actual = calculatorService.divide(a, b);
        Assertions.assertEquals(expected, actual);

    }
}

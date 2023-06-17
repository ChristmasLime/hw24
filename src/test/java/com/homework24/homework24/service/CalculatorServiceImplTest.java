package com.homework24.homework24.service;

import com.homework24.homework24.exception.CalculateVoidException;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

public class CalculatorServiceImplTest {

    private CalculatorServiceImpl service = new CalculatorServiceImpl();

    @Test
    public void testWelcome() {
        String expected = "Добро пожаловать в калькулятор !";
        String actual = service.welcome();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPlus() {
        double a = 2.5;
        double b = 3.5;
        String expected = "Результат сложения : " + a + " + " + b + " = " + (a + b);
        String actual = service.plus(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMinus() {
        double a = 5.0;
        double b = 2.0;
        String expected = "Результат вычитания : " + a + " - " + b + " = " + (a - b);
        String actual = service.minus(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMultiply() {
        double a = 2.0;
        double b = 4.0;
        String expected = "Результат умножения : " + a + " * " + b + " = " + (a * b);
        String actual = service.multiply(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDivide() {
        double a = 10.0;
        double b = 2.0;
        String expected = "Результат деления : " + a + " / " + b + " = " + (a / b);
        String actual = service.divide(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPlusWithNullArguments() {
        Assertions.assertThrows(CalculateVoidException.class, () -> {
            service.plus(null, null);
        });
    }
}


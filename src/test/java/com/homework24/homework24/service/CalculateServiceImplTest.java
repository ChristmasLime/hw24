package com.homework24.homework24.service;

import com.homework24.homework24.exception.CalculateDivideByZero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculateServiceImplTest {

    private CalculateServiceImpl service = new CalculateServiceImpl();


    @Test
    public void testPlus() {
        double a = 2.5;
        double b = 3.5;
        double expected = a + b;
        double actual = service.plus(a, b);
        assertEquals(expected, actual);
    }

    @Test
    public void testPlusNotEquals() {
        double a = 2.5;
        double b = 3.5;
        double expected = a - b;
        double actual = service.plus(a, b);
        assertNotEquals(expected, actual);
    }

    @Test
    public void testMinus() {
        double a = 5.0;
        double b = 2.0;
        double expected = a - b;
        double actual = service.minus(a, b);
        assertEquals(expected, actual);
    }

    @Test
    public void testMinusNotEqual() {
        assertNotEquals(5, service.minus(5, 12));
    }

    @Test
    public void testMultiply() {
        double a = 2.0;
        double b = 4.0;
        double expected = a * b;
        double actual = service.multiply(a, b);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimetryMultuply() {
        assertEquals(service.multiply(7,3),service.multiply(3,7));
    }

    @Test
    public void testDivide() throws CalculateDivideByZero {
        double a = 10.0;
        double b = 2.0;
        double expected = a / b;
        double actual = service.divide(a, b);
        assertEquals(expected, actual);
    }

    @Test
    public void testNoSimetryDivide()throws CalculateDivideByZero {
        assertNotEquals(service.divide(3,7),service.divide(7,3));
    }

    @Test
    public void divideByZero() {
        assertThrows(CalculateDivideByZero.class, () -> service.divide(7, 0));
    }
}

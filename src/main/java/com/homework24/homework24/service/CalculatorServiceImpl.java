package com.homework24.homework24.service;

import com.homework24.homework24.exception.CalculateVoidException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String welcome() {
        return "Добро пожаловать в калькулятор !";
    }

    @Override
    public String plus(Double a, Double b) {
        try {
            checkArguments(a, b);
            return "Результат сложения : " + a + " + " + b + " = " + (a + b);
        } catch (CalculateVoidException e) {
            e.printStackTrace();
            throw new CalculateVoidException("Недостаточно параметров");
        }
    }

    @Override
    public String minus(Double a, Double b) {
        try {
            checkArguments(a, b);
            return "Результат вычитания : " + a + " - " + b + " = " + (a - b);
        } catch (CalculateVoidException e) {
            e.printStackTrace();
            return "Недостаточно параметров";
        }
    }

    @Override
    public String multiply(Double a, Double b) {
        try {
            checkArguments(a, b);
            return "Результат умножения : " + a + " * " + b + " = " + (a * b);
        } catch (CalculateVoidException e) {
            e.printStackTrace();
            return "Недостаточно параметров";
        }
    }

    @Override
    public String divide(Double a, Double b) {
        try {
            checkArguments(a, b);
            if (b == 0) {
                throw new IllegalArgumentException("Делить на ноль нельзя!");
            }
            return "Результат деления : " + a + " / " + b + " = " + (a / b);
        } catch (CalculateVoidException | IllegalArgumentException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    private void checkArguments(Double a, Double b) {
        if (a == null || b == null) {
            throw new CalculateVoidException("Недостаточно параметров");
        }

    }
}

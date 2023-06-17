package com.homework24.homework24.controller;

import com.homework24.homework24.service.CalculatorServiceImpl;
import com.sun.jdi.connect.Connector;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorServiceImpl service;

    public CalculatorController(CalculatorServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public String getWelcome() {
        return service.welcome();
    }

    @GetMapping("/plus")
    public String getPlus(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        return service.plus(num1, num2);
    }
      @GetMapping("/minus")
    public String getMinus(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        return service.minus(num1, num2);
    }

    @GetMapping("/multiply")
    public String getMultiply(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        return service.multiply(num1, num2);
    }
    @GetMapping("/divide")
    public String getDivide(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        return service.divide(num1, num2);
    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMissingParams(MissingServletRequestParameterException ex) {
        return "Недостаточно параметров";
    }



}

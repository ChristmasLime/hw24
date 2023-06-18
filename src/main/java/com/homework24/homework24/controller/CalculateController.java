package com.homework24.homework24.controller;

import com.homework24.homework24.service.CalculateService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculateController {

    private final CalculateService service;

    public CalculateController(CalculateService service) {
        this.service = service;
    }

    @GetMapping
    public String getWelcome() {
        return "Добро пожаловать в калькулятор!";
    }

    @GetMapping("/plus")
    public String getPlus(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        return String.format("%s +%s=%s",num1,num2,service.plus(num1, num2));
    }

    @GetMapping("/minus")
    public String getMinus(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        return String.format("%s -%s=%s",num1,num2,service.minus(num1, num2));
    }

    @GetMapping("/multiply")
    public String getMultiply(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        return String.format("%s *%s=%s",num1,num2,service.multiply(num1, num2));
    }

    @GetMapping("/divide")
    public String getDivide(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        try {
            return String.format("%s /%s=%s", num1, num2, service.divide(num1, num2));
        } catch (Exception e) {
            return "Делить на ноль нельзя!";
        }
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMissingParams(MissingServletRequestParameterException ex) {
        return "Недостаточно параметров";
    }
}

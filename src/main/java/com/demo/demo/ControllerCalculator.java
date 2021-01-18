package com.demo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/rest/")
@RestController
public class ControllerCalculator {
    private Calculator calculatorService;

    @Autowired
    public void Controller(Calculator calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("plus")
    public float getPlus(
            @RequestParam(value = "a") float a,
            @RequestParam(value = "b") float b
    ) {
        return calculatorService.plus(a, b);
    }

    @GetMapping("minus")
    public float getMinus(
            @RequestParam(value = "a") float a,
            @RequestParam(value = "b") float b
    ) {
        return calculatorService.minus(a, b);
    }

    @GetMapping("divide")
    public float getDivide(
            @RequestParam(value = "a") float a,
            @RequestParam(value = "b") float b
    ) {
        return calculatorService.divide(a, b);
    }

    @GetMapping("times")
    public float getTimes(
            @RequestParam(value = "a") float a,
            @RequestParam(value = "b") float b
    ) {
        return calculatorService.times(a, b);
    }

    @GetMapping("mod")
    public float getMod(
            @RequestParam(value = "a") float a,
            @RequestParam(value = "b") float b
    ) {
        return calculatorService.mod(a, b);
    }
}

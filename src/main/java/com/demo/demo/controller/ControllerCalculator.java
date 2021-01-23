package com.demo.demo.controller;

import com.demo.demo.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.BadRequestException;


@RequestMapping("/rest/")
@RestController
public class ControllerCalculator {
    private Calculator calculatorService;

    @Autowired
    public void Controller(Calculator calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("plus")
    public ResponseEntity getPlus(
            @RequestParam(value = "a") float a,
            @RequestParam(value = "b") float b
    ) {
        return ResponseEntity.ok().body(calculatorService.plus(a, b));
    }

    @GetMapping("minus")
    public ResponseEntity getMinus(
            @RequestParam(value = "a") float a,
            @RequestParam(value = "b") float b
    ) {
        return ResponseEntity.ok().body(calculatorService.minus(a, b));
    }

    @GetMapping("divide")
    public ResponseEntity getDivide(
            @RequestParam(value = "a") float a,
            @RequestParam(value = "b") float b
    ) {
        try{
            calculatorService.divide(a,b);
            return ResponseEntity.ok().body(calculatorService.divide(a,b));
        }catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Divide By Null");
        }
   }

    @GetMapping("times")
    public ResponseEntity getTimes(
            @RequestParam(value = "a") float a,
            @RequestParam(value = "b") float b
    ) {
        return ResponseEntity.ok().body(calculatorService.times(a, b));
    }

    @GetMapping("mod")
    public ResponseEntity getMod(
            @RequestParam(value = "a") float a,
            @RequestParam(value = "b") float b
    ) {
        try{
            calculatorService.mod(a, b);
            return ResponseEntity.ok().body(calculatorService.mod(a, b));
        }catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mod By Null");
        }
    }
}

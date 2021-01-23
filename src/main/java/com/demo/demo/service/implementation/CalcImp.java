package com.demo.demo.service.implementation;

import com.demo.demo.service.Calculator;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;

@Service
public class CalcImp implements Calculator {
    @Override
    public float plus(float a, float b) {
        return a+b;
    }

    @Override
    public float minus(float a, float b) {
        return a-b;
    }

    @Override
    public float divide(float a, float b) {
        if(b==0) {
            throw new BadRequestException("Divide By Null. ");
        }
        return a/b;
    }

    @Override
    public float times(float a, float b) {
        return a*b;
    }

    @Override
    public float mod(float a, float b) {
        if(b==0)
            throw new BadRequestException("Mod by null");
        if(b < 0) {
            b = b*-1;
        }
        return a%b;
    }
}

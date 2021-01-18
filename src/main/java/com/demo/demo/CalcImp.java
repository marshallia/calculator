package com.demo.demo;

import org.springframework.stereotype.Service;

@Service
public class CalcImp implements Calculator{
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
        return a/b;
    }

    @Override
    public float times(float a, float b) {
        return a*b;
    }

    @Override
    public float mod(float a, float b) {
        if(b < 0) {
            b = b*-1;
        }
        return a%b;
    }
}

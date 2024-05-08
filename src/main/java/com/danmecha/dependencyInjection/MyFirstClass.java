package com.danmecha.dependencyInjection;

import org.springframework.stereotype.Component;


public class MyFirstClass {
    private String myVar;

    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String getVar() {
        return " I am " + myVar;
    }
}
package com.flysall.springtutorial.core;

public class BeanLifeDemo {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        System.out.println("Bean is invoking method setMessage(String message).");
    }

    public void init() {
        System.out.println("Bean is invoking method init().");
    }

    public void destroy() {
        System.out.println("Bean is invoking method cleanup().");
    }
}

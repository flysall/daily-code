package com.flysall.springtutorial.core;

public class ConfigLifeCycleDemo {
    public void init() {
        System.out.println("Inside ConfigLifeCycleDemo.init()");
    }

    public void cleanup() {
        System.out.println("Inside ConfigLifeCycleDemo.cleanup()");
    }
}

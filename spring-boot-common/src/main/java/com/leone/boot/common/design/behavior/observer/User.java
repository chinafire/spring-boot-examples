package com.leone.boot.common.design.behavior.observer;

/**
 * <p> 观察者 实现了update方法
 *
 * @author leone
 * @since 2018-08-22
 **/
public class User implements Observer {

    private String name;

    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + " receive message: " + message);
    }

}
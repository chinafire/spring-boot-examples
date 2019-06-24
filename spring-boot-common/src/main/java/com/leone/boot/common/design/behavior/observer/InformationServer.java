package com.leone.boot.common.design.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 被观察者
 * 实现了BeObserver接口，对BeObserver接口的三个方法进行了具体实现
 *
 * @author leone
 * @since 2018-08-22
 **/
public class InformationServer implements BeObserver {

    // 注意到这个List集合的泛型参数为Observer接口，设计原则:面向接口编程而不是面向实现编程
    private List<Observer> list;

    private String message;

    public InformationServer() {
        list = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if (!list.isEmpty()) {
            list.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < list.size(); i++) {
            Observer observer = list.get(i);
            observer.update(message);
        }
    }

    /**
     * 消息更新，通知所有观察者
     *
     * @param s
     */
    public void setInformation(String s) {
        this.message = s;
        notifyObserver();
    }

}
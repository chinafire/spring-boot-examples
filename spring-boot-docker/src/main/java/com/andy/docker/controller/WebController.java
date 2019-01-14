package com.andy.docker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> 
 *
 * @author Leone
 * @since 2018-03-06
 **/
@Slf4j
@RestController
public class WebController {

    private Integer sum;

    @GetMapping("/hello_world")
    public String sayHelloWorld() {
        return "success-docker!";
    }


    @GetMapping("/debug")
    public String debug(String name) throws Exception {
        sum = 0;
        System.out.println("hello");
        sum += 3;
        System.out.println("world");
        sum = 5;
        System.out.println("hello");
        sum = 23;
        System.out.println("hello");
        if (sum > 23) {
            System.out.println("hi");
        }
        for (int i = 1; i < 3; i++) {
            System.out.println("i:" + i);
        }
        System.out.println("hello");
        sum += 1;
        System.out.println("world");
        Thread.sleep(1000);
        System.out.println("hello");
        return "success-debug-" + name;
    }

}

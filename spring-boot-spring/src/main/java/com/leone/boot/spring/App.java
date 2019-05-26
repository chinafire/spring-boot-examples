package com.leone.boot.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author leone
 * @since 2018-06-29
 **/
@SpringBootApplication
public class App {

    public static void main(String[] args) {

//        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:\\spring.xml");
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring.xml"));

//        System.out.println("getApplicationName:" + applicationContext.getApplicationName());
//        System.out.println("getDisplayName:" + applicationContext.getDisplayName());
//        System.out.println("getId:" + applicationContext.getId());
//        System.out.println("getStartupDate:" + applicationContext.getStartupDate());
//
//        Person person1 = applicationContext.getBean("001", Person.class);
//        Teacher teacher = applicationContext.getBean("teach", Teacher.class);
//        Student student1 = (Student) applicationContext.getBean("student");
//
//
//        person1.hello("james");

        SpringApplication.run(App.class, args);

    }
}

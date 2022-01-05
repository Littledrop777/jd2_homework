package by.academy.it.service;

import by.academy.it.pojo.Person;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PersonService {

    @PostConstruct
    public void init() {
        System.out.println("PersonService init method");
    }

    public void print(Person person) {
        System.out.println("Hello! My name " + person.getName());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PersonService destroy method");
    }

}

package com.basic_dl.set.bean;

import org.springframework.stereotype.Component;

/**
 * @author ZhuYi
 * @create 2024/7/15 18:30
 */
//@Component //开启xml注解扫描时才使用
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

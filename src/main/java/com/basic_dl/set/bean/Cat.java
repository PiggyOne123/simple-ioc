package com.basic_dl.set.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author ZhuYi
 * @create 2024/7/15 18:30
 */
//@Component //开启xml注解扫描时才使用
public class Cat {
    private String name;
    private Person person;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", person=" + person +
                '}';
    }
}

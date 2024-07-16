package com.basic_dl.annotationContext.config;


import com.basic_dl.set.bean.Cat;
import com.basic_dl.set.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author ZhuYi
 * @create 2024/7/16 17:51
 */
@Configuration
//@ImportResource("classpath:basic_dl/scan.xml")//注解引入xml时才使用
public class QuickStartConfiguration {

    @Bean(name = "person")
    public Person person() {
        Person person = new Person();
        person.setName("朱毅");
        person.setAge(18);
        return person;
    }

    @Bean(name = "cat")
    public Cat cat(){
        Cat cat = new Cat();
        cat.setName("Tom");
        cat.setPerson(person());
        return cat;
    }
}

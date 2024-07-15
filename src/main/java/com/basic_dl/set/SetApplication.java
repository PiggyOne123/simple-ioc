package com.basic_dl.set;

import com.basic_dl.set.bean.Cat;
import com.basic_dl.set.bean.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhuYi
 * @create 2024/7/15 18:32
 */
public class SetApplication {
    public static void main(String[] args) {
        /**
         * 依赖注入
         */
        BeanFactory factory =new ClassPathXmlApplicationContext("/basic_dl/set.xml");
        Person person = factory.getBean(Person.class);
        System.out.println(person);

        Cat cat = factory.getBean(Cat.class);
        System.out.println(cat);
    }
}
